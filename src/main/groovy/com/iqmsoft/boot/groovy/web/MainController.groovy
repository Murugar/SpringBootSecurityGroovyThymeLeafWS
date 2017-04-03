package com.iqmsoft.boot.groovy.web

import org.omg.CORBA.Request
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@Controller
@RequestMapping(value = "/")
@Scope("request")
class MainController {

	@RequestMapping(method = RequestMethod.GET)
	def home(Model model){
		model.addAttribute('name1', "Peter")
		return "index"
	}

}
