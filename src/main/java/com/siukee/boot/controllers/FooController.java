package com.siukee.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.siukee.exception.SomeException;


@Controller
public class FooController {

  @RequestMapping("/return-model-and-view")
  public ModelAndView returnModelAndView() throws SomeException {
    throw new SomeException();
  }

  @RequestMapping("/return-view-name")
  public String returnViewName() throws SomeException {
    throw new SomeException();
  }

  @RequestMapping("/return-view")
  public View returnView() throws SomeException {
    throw new SomeException();
  }

  @RequestMapping(value = "/return-text-plain", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
  @ResponseBody
  public String returnPlainText() throws SomeException {
    throw new SomeException();
  }

  @RequestMapping(value = "/return-json-1", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String returnJson1() throws SomeException {
    throw new SomeException();
  }

}
