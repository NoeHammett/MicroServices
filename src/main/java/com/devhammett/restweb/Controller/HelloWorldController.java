package com.devhammett.restweb.Controller;

import java.util.Locale;

import com.devhammett.restweb.Models.HelloBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = "application/json")
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    //Return a String
    // @RequestMapping(method = RequestMethod.GET, value = "/hello")
    @GetMapping(path = "/hello")
    public String Hello(){
        return "Hello World";
    }

    // @GetMapping(path = "/helloInternational")
    // public String HelloInternational(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
    //     return messageSource.getMessage("wave.message", null,"Hello World", locale);
    // }

    @GetMapping(path = "/helloInternational")
    public String HelloInternational(){
        return messageSource.getMessage("wave.message", null,"Hello World", LocaleContextHolder.getLocale());
    }

    @GetMapping(path = "/helloBean")
    public HelloBean HelloBean(){
        return new HelloBean("Hola Mundo!");
    }

    @GetMapping(path = "/hello/{name}")
    public HelloBean HelloBeanName(@PathVariable String name){
        return new HelloBean(String.format("Hola, " + name+ "!"));
    }
    
    
}
