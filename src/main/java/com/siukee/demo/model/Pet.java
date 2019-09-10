package com.siukee.demo.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("宠物信息")
@Data
public class Pet implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -3234864106711936730L;

	@ApiModelProperty(name="petId", value="宠物ID")
    private String petId;
    
    @ApiModelProperty(name="name", value="宠物名称")
    private String name;
    
    @ApiModelProperty(name="type", value="宠物类型")
    private String type;
    
    @ApiModelProperty(name="description", value="宠物描述")
    private String description;
}
