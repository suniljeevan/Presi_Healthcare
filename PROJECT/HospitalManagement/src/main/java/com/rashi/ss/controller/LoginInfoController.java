/*package com.rashi.ss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rashi.ss.pojo.LoginInfoPojo;
import com.rashi.ss.service.LoginInfoService;

@RequestMapping("/login/Info")
@RestController
public class LoginInfoController {

	@Autowired
	private LoginInfoService loginInfoService;
	
	@PostMapping("/save")
	public void saveInfo(@RequestBody LoginInfoPojo loginInfoPojo) {
		loginInfoService.saveInfo(loginInfoPojo);
	}
	
}
*/