package edu.kh.todo.model.dao;
import static edu.kh.todo.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.todo.model.dto.Todo;


public class TodoDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private Properties prop;
	
	public TodoDAO() {
		try {
			prop = new Properties();
			
			String filePath = TodoDAO.class.getResource("/edu/kh/todo/sql/todo-sql.xml").getPath();
			prop.loadFromXML(new FileInputStream(filePath));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	public List<Todo> selectAll(Connection conn, int memberNo) throws Exception {

		List<Todo> tdList = new ArrayList<Todo>();
		
		try {
			String sql = prop.getProperty("todolist");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next() ) {
				Todo todo = new Todo();
				
				todo.setTodoNo(rs.getInt(1));
				todo.setTodoTitle(rs.getString(2));
				todo.setTodoMemo(rs.getString(3));
				todo.setTodoDate(rs.getString(4));
				todo.setTodoDelflag(rs.getString(5));
				todo.setMemberNo(memberNo);
				tdList.add(todo);
			}
			
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return tdList;
	}

	public int ist(Connection conn, String subject, String memo, int memberNumber) throws Exception{
		int result = 0;
		
		
		try {
			String sql = prop.getProperty("insertmemo");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, subject);
			pstmt.setString(2, memo);
			pstmt.setInt(3, memberNumber);
				
				
				
				
			result = pstmt.executeUpdate();
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteTodo(Connection conn, String deleteNum) throws	Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("delete");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, deleteNum);
			
			result = pstmt.executeUpdate();
			
			
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int update(Connection conn, String subject, String memo, String modifyNum) throws Exception {
		int result = 0;
		
		try {
			String sql = prop.getProperty("modify");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, subject);
			pstmt.setString(2, memo);
			pstmt.setString(3, modifyNum);
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public List<Todo> nowTodo(Connection conn, String modifyNum) throws Exception{
		List<Todo> tdList = new ArrayList<Todo>();
		
		try {
			String sql = prop.getProperty("now");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, modifyNum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next() ) {
				Todo todo = new Todo();
				
				todo.setTodoNo(rs.getInt(1));
				todo.setTodoTitle(rs.getString(2));
				todo.setTodoMemo(rs.getString(3));
				todo.setTodoDate(rs.getString(4));
				todo.setTodoDelflag(rs.getString(5));
				todo.setMemberNo(rs.getInt(6));
				tdList.add(todo);
			}
			
			
			
		} finally {
			close(rs);
			close(pstmt);
		}
		return tdList;
	}


		
		
		


		
		
	

}
