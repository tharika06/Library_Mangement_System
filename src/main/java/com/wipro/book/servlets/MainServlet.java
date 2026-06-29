package com.wipro.book.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.bean.BookBean;
import com.wipro.book.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private Administrator admin=new Administrator();
    
	public String addBook(HttpServletRequest request) {
		BookBean bean=new BookBean();
		bean.setIsbn(request.getParameter("isbn"));
		bean.setBookName(request.getParameter("bookName"));
		bean.setBookType(request.getParameter("bookType").charAt(0));
		bean.setCost(Float.parseFloat(request.getParameter("cost")));
		AuthorBean author=new AuthorBean();
		author.setAuthorName(request.getParameter("authorName"));
		author.setAuthorCode(Integer.parseInt(request.getParameter("authorCode")));
		bean.setAuthor(author);
		return admin.addBook(bean);
	}
	
	public BookBean viewBook(String isbn) {
		return admin.viewBook(isbn);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation=request.getParameter("operation");
		if(operation.equals("AddBooks")) {
			String res=addBook(request);
			if(res.equals("SUCCESS")) {
				response.sendRedirect("Menu.html");
			}
			else if(res.equals("FAILURE")) {
				response.sendRedirect("Failure.html");
			}
			else {
				response.sendRedirect("Invalid.html");
			}
		}
		
		else if(operation.equals("Search")) {
			String isbn=request.getParameter("isbn");
			BookBean bean=viewBook(isbn);
			if(bean==null)
				response.sendRedirect("Invalid.html");
			else {
				request.setAttribute("book", bean);
				RequestDispatcher rd=request.getRequestDispatcher("DisplayBook.jsp");
				rd.forward(request, response);
			}
				
		}
	}

}
