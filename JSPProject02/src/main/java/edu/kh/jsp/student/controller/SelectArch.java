package edu.kh.jsp.student.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.jsp.student.model.dto.Student;
import edu.kh.jsp.student.model.service.archService;


@WebServlet("/jstl/student/selectArch")
public class SelectArch extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		archService service = new archService();
		
		
		
		try {
		
			List<Student> arch = service.selectArch();
			
			req.setAttribute("arch", arch);
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		
		
		
		
		
		req.getRequestDispatcher("/WEB-INF/views/student/selectArch.jsp").forward(req, resp);
	}

}
