package com.wipro.book.service;

import java.util.ArrayList;

import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.BookDAO;


public class Administrator {

	public String addBook(BookBean bookBean) {
		try {
		if(bookBean!=null && 
		   !bookBean.getBookName().trim().isEmpty() && 
	       !bookBean.getIsbn().trim().isEmpty() && 
	       (bookBean.getBookType()=='G'||
		   bookBean.getBookType()=='T')&& 
		   bookBean.getCost()!=0 && 
		   !bookBean.getAuthor().getAuthorName().trim().isEmpty()) {
			
			BookDAO dao=new BookDAO();
			int rows=dao.createBook(bookBean);
			if(rows>0)
			    return "SUCCESS";
			else
				return "FAILURE";
		}
		else {
			return "INVALID";
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return "FAILURE";
	}
	
	public BookBean viewBook(String isbn){
	 BookDAO dao=new BookDAO();
	 if(isbn==null||isbn.trim().isEmpty())
		 return null;
	 else {
		 return dao.fetchBook(isbn);
	 }
	}
	 
}

	