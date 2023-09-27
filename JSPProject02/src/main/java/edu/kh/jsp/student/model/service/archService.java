package edu.kh.jsp.student.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static edu.kh.jsp.common.JDBCTemplate.*;
import edu.kh.jsp.model.dao.StudentDAO;
import edu.kh.jsp.student.model.dto.Student;

public class archService {
	
	private StudentDAO dao = new StudentDAO();

	public List<Student> selectArch() throws SQLException {
		
		Connection conn = getConnection();
		
		List<Student> arch = dao.selectArch(conn);
		
		
		close(conn);
		return arch;
	}

}
