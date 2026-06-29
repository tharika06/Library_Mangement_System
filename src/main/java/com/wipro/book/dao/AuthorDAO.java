package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.util.DBUtil;

public class AuthorDAO {
public AuthorBean getAuthor(int authorCode) {
	AuthorBean bean=null;
	try {
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM Author_Tbl WHERE Author_code=?");
		ps.setInt(1, authorCode);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
		    bean=new AuthorBean();
			bean.setAuthorCode(rs.getInt(1));
			bean.setAuthorName(rs.getString(2));
			bean.setContactNo(rs.getLong(3));
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

public AuthorBean getAuthor(String authorName) {
	AuthorBean bean=null;
	try {
		Connection con=DBUtil.getDBConnection();
		PreparedStatement ps=con.prepareStatement("SELECT * FROM Author_Tbl WHERE Author_name=?");
		ps.setString(1, authorName);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			bean=new AuthorBean();
			bean.setAuthorCode(rs.getInt(1));
			bean.setAuthorName(rs.getString(2));
			bean.setContactNo(rs.getLong(3));
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	return bean;
}
}
