package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.bean.BookBean;
import com.wipro.book.util.DBUtil;

public class BookDAO {
public BookBean fetchBook(String isbn) {
	BookBean bean=null;
	try {
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM "
				+ "Book_Tbl b JOIN Author_Tbl a "
				+ "ON(b.Author_code=a.Author_code) "
				+ "WHERE isbn=?");
		ps.setString(1, isbn);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			bean=new BookBean();
			bean.setIsbn(rs.getString(1));
			bean.setBookName(rs.getString(2));
			bean.setBookType(rs.getString(3).charAt(0));
			bean.setCost(rs.getFloat(5));
			
			AuthorBean author=new AuthorBean();
			author.setAuthorCode(rs.getInt(6));
			author.setAuthorName(rs.getString(7));
			author.setContactNo(rs.getLong(8));
			
			bean.setAuthor(author);
			
		}
		rs.close();
		ps.close();
		con.close();			
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return bean;
}

public int createBook(BookBean bookBean) {
	int flag=0;
	try {
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps=con.prepareStatement("INSERT INTO BOOK_TBL VALUES(?,?,?,?,?)");
		ps.setString(1,bookBean.getIsbn() );
		ps.setString(2,bookBean.getBookName());
		ps.setString(3,String.valueOf(bookBean.getBookType()));
		ps.setInt(4,bookBean.getAuthor().getAuthorCode());
		ps.setFloat(5,bookBean.getCost());
		int rows=ps.executeUpdate();
		if(rows>0)
			flag=1;
		ps.close();
		con.close();		
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return flag;
	
}
}
