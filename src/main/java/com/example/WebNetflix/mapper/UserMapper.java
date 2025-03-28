package com.example.WebNetflix.mapper;

import com.example.WebNetflix.model.User;
import com.example.WebNetflix.model.UserExample;
import com.example.WebNetflix.model.UserKey;
import com.example.WebNetflix.model.UserWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Mon Mar 10 10:09:11 ICT 2025
	 */
	long countByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Mon Mar 10 10:09:11 ICT 2025
	 */
	int deleteByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Mon Mar 10 10:09:11 ICT 2025
	 */
	int insert(User row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Mon Mar 10 10:09:11 ICT 2025
	 */
	int insertSelective(User row);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Mon Mar 10 10:09:11 ICT 2025
	 */
	List<User> selectByExample(UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Mon Mar 10 10:09:11 ICT 2025
	 */
	int updateByExampleSelective(@Param("row") User row, @Param("example") UserExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user
	 * @mbg.generated  Mon Mar 10 10:09:11 ICT 2025
	 */
	int updateByExample(@Param("row") User row, @Param("example") UserExample example);
	
	
	List<Map<String, Object>> getAllUsers(Map<String, Object> param);
	
	
	
}