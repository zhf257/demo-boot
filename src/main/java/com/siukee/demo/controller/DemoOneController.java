package com.siukee.demo.controller;

import javax.validation.constraints.Email;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siukee.demo.model.JsonRequest;
import com.siukee.demo.model.RegisterDto;

@RestController
@RequestMapping("/do")
@Validated
public class DemoOneController {
	
	
	@GetMapping("/{group:[a-zA-Z0-9_]+}/{userid}")
	public String path(@PathVariable("group") String group, @PathVariable("userid") Integer userid) {
	    return group + ":" + userid;
	}
	
	@GetMapping("/param")
	public String param(@RequestParam("group") @Email String group, 
	                    @RequestParam("userid") Integer userid) {
	   return group + ":" + userid;
	}
	
	@PostMapping("/json")
	public JsonRequest form(@Validated @RequestBody JsonRequest request) {
	    return request;
	}
	@PostMapping("/register")
	public RegisterDto register(@Validated @RequestBody RegisterDto request) {
		return request;
	}
}
