package com.bikeme.controller;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bikeme.dao.UserDao;
import com.bikeme.model.User;

@RestController
@RequestMapping("/")
public class UserController implements Serializable {

	private static final long serialVersionUID = 1324281204513252405L;

	@Autowired
	private UserDao userDAO;
	
	@RequestMapping(
			value = "login",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE,
			params = { "username", "password" })
	@ResponseBody
	public String loginUser(
			@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password ) {
		boolean result = userDAO.checkUser(username, password);
		
		JSONObject entity = new JSONObject();
        try {
			entity.put("success", result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
        
		return  entity.toString();
	}
	
	@RequestMapping(
			value = "/register",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String registerUser(@RequestBody User user) throws Exception {
	    boolean result = userDAO.createUser(user);
	    
	    JSONObject entity = new JSONObject();
        try {
			entity.put("success", result);
		} catch (JSONException e) {
			e.printStackTrace();
		}
        
		return  entity.toString();
	}

}
