package com.example.WebNetflix.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.WebNetflix.mapper.UserMapper;
import com.example.WebNetflix.model.User;
import com.example.WebNetflix.model.UserExample;

@Controller
public class HomePageController {
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/")
	public ModelAndView index() {
		 ModelAndView modelAndView = new ModelAndView("index");
		 
//		 UserExample example = new UserExample();
//		 example.createCriteria().andIdEqualTo((long)1).andUserNameEqualTo("Thuat");
//		 
//		 List<User> listUser =  userMapper.selectByExample(example);
//	
//		 for(User value : listUser) {
//			 System.out.println("Kiem tra: "+ value.getFullName());
//		 }
		 
		 Map<String, Object> param = new HashMap<String, Object>();
		 param.put("userName", "Thuat");
		 param.put("id", 1);
		 
		 List<Map<String, Object>> listUser =  userMapper.getAllUsers(param);
		 for(Map<String,  Object> value : listUser) {
			 System.out.println("Kiem tra: " + value.get("full_name"));
		 }
		 
		 return modelAndView;
	}
}
    