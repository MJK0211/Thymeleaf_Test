package com.mjk.thymeleafTest.persistence;

import static org.assertj.core.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class JDBCTest {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testConnection() {

		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "1234")) {

			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
