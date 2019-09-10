package com.siukee.boot.errorattributes;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.web.context.request.WebRequest;

public class CustomErrorAttributes implements ErrorAttributes {

	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
		Map<String, Object> result = new HashMap<>();
		result.put("timestamp", System.currentTimeMillis());
		result.put("error", "customized error");
		result.put("path", "customized path");
		result.put("status", 100);
		result.put("exception", webRequest);
		result.put("message", "customized message");
		result.put("trace", "customized trace");
		result.put("add-attribute", "add-attribute");
		return result;
	}

	@Override
	public Throwable getError(WebRequest webRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
