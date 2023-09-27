package edu.kh.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.member.model.dto.Member;
import edu.kh.todo.model.dto.Todo;
import edu.kh.todo.model.service.TodoService;


@WebServlet("/update")
public class UpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	try {
		HttpSession session = req.getSession();
		String modifyNum = req.getParameter("no");
		Member member = (Member) session.getAttribute("loginMember");
		int memberNumber = member.getMemberNo();
		
		TodoService service = new TodoService();
		
		List<Todo> tdList = service.nowTodo(modifyNum);
		
		session.setAttribute("tdList", tdList);
		System.out.println("todolist값" + tdList);
		req.getRequestDispatcher("/WEB-INF/views/update.jsp").forward(req, resp);
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	
	
	/*
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			req.setCharacterEncoding("UTF-8");
			HttpSession session = req.getSession();
			
			String modifyNum = req.getParameter("no");
			System.out.println(modifyNum);
			
			
			String subject = req.getParameter("subject");
			String memo = req.getParameter("memo");
			
			Member member = (Member) session.getAttribute("loginMember");
			
			TodoService istService = new TodoService();
			
			int memberNumber = member.getMemberNo();
			
			int result = istService.update(subject, memo, modifyNum);
			
			List<Todo> tdList = istService.selectAll(memberNumber);
			
			session.setAttribute("tdList", tdList);
			
			resp.sendRedirect("/");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
*/
}
