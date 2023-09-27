package edu.kh.jsp.student.model.service;

import static edu.kh.jsp.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import edu.kh.jsp.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class StudentService {

	private StudentDAO dao = new StudentDAO();
	
	public List<Student> selectAll() throws SQLException {
		
		// 1. Connection 생성
		Connection conn = getConnection();
		
		// 2. DAO 호출
		List<Student> stdList = dao.selectAll(conn);
		
		// 3. 트랜제어 select 필요 없음
		
		// 4. Connection 반환
		close(conn);
		
		return stdList;
	}
	
}
