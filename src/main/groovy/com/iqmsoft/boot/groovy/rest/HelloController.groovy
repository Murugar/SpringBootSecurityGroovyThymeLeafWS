package com.iqmsoft.boot.groovy.rest

import org.omg.CORBA.Request
import org.springframework.context.annotation.Scope
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = "/rest")
@Scope("request")
class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	def home(){
		return "Hello World"
	}
	
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    def hello(@PathVariable def name){
        return "Greetings " + name    
	}

}
