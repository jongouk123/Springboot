package com.study.springboot.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyUserDAO {
	// DAO는 @Repository 어노테이션을 사용하여 빈으로 등록한다.
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<MyUserDTO> list() {
		String query = "select * from myuser";
		
		// jdbcTemplate.query
		// SELECT 쿼리의 결과(ResultSet)를 각 row 마다 MyUserDTO 객체로 받아서 전체 데이터를 list로 반환한다.
		List<MyUserDTO> list = jdbcTemplate.query( query, new BeanPropertyRowMapper<MyUserDTO>(MyUserDTO.class) );
		
//		for ( MyUserDTO my : list ) {
//			System.out.println( my );
//		}
		
		return list;
	}
}
