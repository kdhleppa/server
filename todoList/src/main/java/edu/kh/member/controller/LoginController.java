package edu.kh.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.member.model.dto.Member;
import edu.kh.member.model.service.MemberService;
import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			req.setCharacterEncoding("UTF-8");
			
			String inputId = req.getParameter("inputId");
			String inputPw = req.getParameter("inputPw");
			
			MemberService service = new MemberService();
			TodoService tdservice = new TodoService();
			
			
			Member loginMember = service.login(inputId, inputPw);
			
			
			
			System.out.println(loginMember);
			
			HttpSession session = req.getSession();
			
			if(loginMember != null) {
				List<Todo> tdList = tdservice.selectAll(loginMember.getMemberNo());
				
				
				
				session.setAttribute("loginMember", loginMember);
				session.setAttribute("tdList", tdList);
				resp.sendRedirect("/");
				System.out.println(tdList);
			} else {
				
				
				session.setAttribute("message", "아이디나비번틀림");
				
				String referer = req.getHeader("referer");
				
				resp.sendRedirect(referer);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
