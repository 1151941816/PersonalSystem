package com.Controler.Back;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.BaseDao;

/**
 * 删除图书
 *
 */
public class DelBookAction extends HttpServlet {


	private static final long serialVersionUID = 1L;

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		BaseDao dbm = new BaseDao();
		String sql = "delete from book_info where book_id='"+id+"'";

		Statement stat = null;
		Connection conn = null;
		try {
			conn = dbm.getCon();
			stat = conn.createStatement();
			stat.execute(sql);
		 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stat != null)
					stat.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("http://localhost:8080/PersonalSystem/BookSearch");
		out.flush();
		out.close();
	}

	
}
