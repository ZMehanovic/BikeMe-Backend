package com.bikeme.controller;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Sample controller for going to the home page with a message
 */
@Controller
public class HomeController  implements Serializable {

	private static final long serialVersionUID = 1324281204513252404L;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	/**
	 * Selects the home page and populates the model with a message
	 */
	@RequestMapping(value = "/")
	public String home() {
		System.out.println("\n\n\nKRUMPIRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR\n\n\n\n\n");
		return "home";
	}
	

}
