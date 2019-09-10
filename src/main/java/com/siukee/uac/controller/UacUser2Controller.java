package com.siukee.uac.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.siukee.uac.model.entity.UacUser;

@Controller
@RequestMapping("/user2")
public class UacUser2Controller {
	
	@GetMapping(produces=MediaType.TEXT_HTML_VALUE)
	public String queryPage() {
		System.err.println("======APPLICATION_XHTML_XML_VALUE=======");
		return "add";
	}
	@GetMapping(headers=MediaType.TEXT_HTML_VALUE)
	public String queryPage1() {
		System.err.println("======TEXT_HTML_VALUE=======");
		return "adf";
	}
	
	@GetMapping
	public List<UacUser> query(){
		List<UacUser> users = new ArrayList<UacUser>();
		users.add(new UacUser());
		users.add(new UacUser());
		users.add(new UacUser());
		return users;
	}
}
