package edu.kh.member.model.service;



import edu.kh.member.model.dao.MemberDAO;
import edu.kh.member.model.dto.Member;
import static edu.kh.todo.common.JDBCTemplate.*;

import java.sql.Connection;

public class MemberService {
	
	
	private MemberDAO dao = new MemberDAO();
	

	public Member login(String inputId, String inputPw) throws Exception{

		Connection conn = getConnection();
		
		Member loginMember = dao.login(conn, inputId, inputPw);
		
		close(conn);
		return loginMember;
	}

}
