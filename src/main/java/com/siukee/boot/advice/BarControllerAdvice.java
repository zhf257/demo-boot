package com.siukee.boot.advice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.WebUtils;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.siukee.exception.AnotherException;
import com.siukee.exception.SomeException;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice(annotations= {RestController.class})
@Slf4j
public class BarControllerAdvice implements ResponseBodyAdvice<Object> {

	@ExceptionHandler(SomeException.class)
	String handleSomeException(HttpServletRequest request, Throwable ex) {
		return "/controlleradvice/some-ex-error.html";

	}

	@ExceptionHandler(AnotherException.class)
	@ResponseBody
	ResponseEntity<?> handleAnotherException(HttpServletRequest request, Throwable ex) {
		log.info("======handleAnotherException======");
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(new AnotherExceptionErrorMessage(status.value(), ex.getMessage()), status);
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute(WebUtils.ERROR_STATUS_CODE_ATTRIBUTE);
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}

	@Override
	public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> converterType) {
		log.info("=====supports======="+methodParameter.hasMethodAnnotation(ResponseBody.class));
		return methodParameter.hasMethodAnnotation(ResponseBody.class);
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {
		log.info("=====beforeBodyWrite=======");
		return body;
	}

}
