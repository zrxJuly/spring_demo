package com.zrxjuly.test;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateTB {

	@Test
	public void demo() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test");
		dataSource.setUsername("root");
		dataSource.setPassword("rongxiang");
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("CREATE TABLE temp(`id` int(11) NOT NULL,`name` varchar(32) DEFAULT NULL,`password` varchar(32) DEFAULT NULL,PRIMARY KEY (`id`))");
	}
}
