package com.siukee.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.siukee.demo.ObjectNotFoundException;
import com.siukee.demo.PetManager;
import com.siukee.demo.model.Pet;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Pet Restful api")
@RestController
@RequestMapping("/pets/{customer}")
public class PetsApiController {
	@Autowired
	private PetManager dataManager;

	/**
	 * 添加宠物
	 * 
	 * @param customer
	 * @param pet
	 * @return
	 */
	@ApiOperation("添加宠物")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "customer", dataType = "String", required = true, value = "客户名", defaultValue = ""),
            @ApiImplicitParam(paramType = "body", name = "pet", dataType = "Pet", required = true, value = "pet 请求", defaultValue = "") })
    @ApiResponses({
        @ApiResponse(code = 201, message = "添加成功"),
        @ApiResponse(code = 404, message = "资源不存在")
    })
	@PostMapping
	public ResponseEntity<Object> addPet(@PathVariable String customer, @RequestBody Pet pet) {
		validateCustomer(customer);

		Pet newPet = dataManager.addPet(customer, pet);

		// 返回 201.created
		if (newPet != null) {
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{petId}")
					.buildAndExpand(newPet.getPetId()).toUri();

			return ResponseEntity.created(location).build();
		}

		// 返回 204.noContent
		return ResponseEntity.noContent().build();
	}

	/**
	 * 获取宠物列表
	 * 
	 * @param customer
	 * @return
	 */
	@GetMapping
	@ResponseBody
	public List<Pet> listPets(@PathVariable String customer) {
		validateCustomer(customer);

		List<Pet> pets = dataManager.getPets(customer);
		return pets;
	}

	/**
	 * 获取某个宠物
	 * 
	 * @param customer
	 * @param petId
	 */
	@GetMapping("/{petId}")
	@ResponseBody
	public Pet getPet(@PathVariable String customer, @PathVariable String petId) {
		validateCustomer(customer);
		validatePet(customer, petId);

		Pet pet = dataManager.getPet(customer, petId);
		return pet;
	}

	/**
	 * 更新宠物信息
	 * 
	 * @param customer
	 * @param petId
	 * @param pet
	 */
	@PutMapping("/{petId}")
	public ResponseEntity<Object> updatePet(@PathVariable String customer, @PathVariable String petId,
			@RequestBody Pet pet) {
		validateCustomer(customer);
		validatePet(customer, petId);

		pet.setPetId(petId);
		Pet petObject = dataManager.updatePet(customer, pet);
		if (petObject != null) {
			return ResponseEntity.ok(petObject);
		}

		return ResponseEntity.noContent().build();

	}

	/**
	 * 删除某个宠物
	 * 
	 * @param customer
	 * @param petId
	 * @return
	 */
	@DeleteMapping("/{petId}")
	public ResponseEntity<Object> removePet(@PathVariable String customer, @PathVariable String petId) {
		validateCustomer(customer);
		validatePet(customer, petId);

		dataManager.removePet(customer, petId);
		return ResponseEntity.ok().build();
	}

	/**
	 * 校验customer是否存在
	 * 
	 * @param customer
	 */
	private void validateCustomer(String customer) {
		if (dataManager.getCustomer(customer) == null) {
			throw new ObjectNotFoundException(String.format("the customer['%s'] is not found", customer));
		}
	}

	/**
	 * 校验pet是否存在
	 * 
	 * @param customer
	 */
	private void validatePet(String customer, String petId) {
		if (dataManager.getPet(customer, petId) == null) {
			throw new ObjectNotFoundException(String.format("the pet['%s/%s'] is not found", customer, petId));
		}
	}
	
	@ResponseBody
	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String objectNotFoundExceptionHandler(ObjectNotFoundException ex) {
	    return ex.getMessage();
	}
}
