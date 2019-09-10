package com.siukee.boot.advice;

import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.siukee.exception.AnotherException;
import com.siukee.exception.SomeException;

@RestController
@RequestMapping("/bar2")
public class Bar2Controller {

  @RequestMapping("/html-a")
  public ModelAndView getHtmlA() throws SomeException {
	  return new ModelAndView("/controlleradvice/some-ex-error.html");
  }

  @RequestMapping("/html-b")
  public String getHtmlB() throws AnotherException {
    throw new AnotherException();
  }

  @RequestMapping(value = "/json-a", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String getJsonA() throws SomeException {
    throw new SomeException();
  }

  @RequestMapping(value = "/json-b", produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  @ResponseBody
  public String getJsonB() throws AnotherException {
    throw new AnotherException();
  }

  @RequestMapping(value = "/text-plain-a", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
  @ResponseBody
  public String getTextPlainA() throws SomeException {
    throw new SomeException();
  }

  @RequestMapping(value = "/text-plain-b", produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
  @ResponseBody
  public String getTextPlainB() throws AnotherException {
    throw new AnotherException();
  }

}
