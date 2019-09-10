package com.siukee.boot.controllers;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.siukee.exception.SomeException;


@RestController
public class FooRestController {

  @RequestMapping(value = "/return-json-2", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  @ResponseBody
  public FooRestController returnJson2() throws SomeException {
    throw new SomeException();
  }

}
