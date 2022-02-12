package com.example.springboot.configuration.mvc;

import com.example.springboot.component.entity.UserEntity;
import com.example.springboot.repository.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    UserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MyUserDetails myUserDetails = new MyUserDetails();
		UserEntity user = userDAO.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("未查询到用户：" + username + "信息！");
		}else {
			myUserDetails.setId(user.getId());
			myUserDetails.setUsername(user.getUsername());
			myUserDetails.setPassword(user.getPassword());
			myUserDetails.setRoles(user.getRoles());
		}
		return myUserDetails;
	}
	
}
