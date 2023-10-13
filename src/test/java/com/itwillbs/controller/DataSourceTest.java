package com.itwillbs.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.persistence.MemberDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class DataSourceTest {
	
	
	private static final Logger logger = LoggerFactory.getLogger(DataSourceTest.class);
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private MemberDAO dao;
	
//	@Test
	public void db_test() {
		logger.debug("ds_test 실행@@@@@@@@");
		
		try {
			Connection con = ds.getConnection();
			logger.debug("con: "+con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}//
	
	@Test
	public void sql_test() {
		logger.debug("실행 성공@@@@@@@: "+dao.getTime());
	}
	
	
}
