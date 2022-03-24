package com.reimbursement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reimbursement.models.GenericResponse;
import com.reimbursement.models.Reimbursement;
import com.reimbursement.models.User;
import com.reimbursement.services.UserServices;

@RestController
@RequestMapping
@CrossOrigin
public class UserController {

	@Autowired
	private UserServices userService;

	@GetMapping("/api/users/getUser/{users_id}")
	public User getUser(@PathVariable(value = "users_id") Long userId) {
		return userService.getUser(userId);
	}

	@GetMapping("api/users/search")
	public List<User> searchUsers(Long roleId) {
		return userService.searchUsers(roleId);
	}

	@PostMapping("api/users/logon")
	public User logOn(@RequestBody User user) throws Exception {
		return userService.userLogon(user);
	}

	
	@PutMapping("/api/users/update")
	public ResponseEntity<GenericResponse> updateUser(@RequestBody User user) {
		if(userService.updateUser(user)) {
			return new ResponseEntity<GenericResponse>(new GenericResponse("Success"), HttpStatus.OK);
		} else {
			return new ResponseEntity<GenericResponse>(new GenericResponse("Error"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}