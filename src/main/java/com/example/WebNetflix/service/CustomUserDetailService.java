package com.example.WebNetflix.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.WebNetflix.mapper.UserMapper;
import com.example.WebNetflix.model.User;
import com.example.WebNetflix.model.UserExample;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserMapper userMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserExample example = new UserExample();
		example.createCriteria().andEmailEqualTo(username);

		List<User> lisUsers = userMapper.selectByExample(example);
 
		if (lisUsers.size() > 0) {
			User user = lisUsers.get(0);

			// [ROLE_USER, ROLE_ADMIN,..]
			List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
			// ROLE_USER, ROLE_ADMIN,..
			GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
			grantList.add(authority);

			UserDetails userDetails = new org.springframework.security.core.userdetails.User(
					user.getUserName(),
					user.getUserPassword(), // Mật khẩu lấy từ database
					grantList);

			return userDetails;
		} else {
			throw new UsernameNotFoundException("Login fail!!");
		}
	}

}
