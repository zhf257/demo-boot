package com.siukee.uac.model.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UacUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	private Long id;
	/**
	 * 工号
	 */
	private String userCode;
	/**
	 * 用户名
	 */
	private String userName;
    /**
     * 头像
     */
	private String avatar;
	/**
	 *  账号
	 */
	private String account;
	/**
	 * 密码
	 */
	private String password;
	/**
     * md5密码盐
     */
	private String salt;
	/**
     * 生日
     */
	private Date birthday;
    /**
     * 性别（1：男 2：女）
     */
	private Integer sex;
    /**
     * 电子邮件
     */
	private String email;
    /**
     * 电话
     */
	private String phone;
	 /**
     * 状态(1：启用  2：冻结  3：删除）
     */
	private Integer status;
	/**
	 * 用户来源
	 */
	private String userSource;
    /**
     * 创建时间
     */
	private Date createtime;
    /**
     * 版本号
     */
	private Integer version;

}
