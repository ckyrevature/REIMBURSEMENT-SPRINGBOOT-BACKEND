package com.reimbursement.services;

import java.sql.SQLException;
import java.util.List;

import com.reimbursement.exception.UserNotFoundException;
import com.reimbursement.models.User;

public interface UserServices {
	public User userLogon(User user);

	public List<User> searchUsers(Long roleId);

	public User getUser(Long userId);

	public boolean updateUser(User user);
}