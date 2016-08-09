

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;


public class ParamServ extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		String driver=config.getInitParameter("driver");
		String url=config.getInitParameter("url");
		String username=config.getInitParameter("username");
		String password=config.getInitParameter("password");
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url, username, password);
			DatabaseMetaData d=conn.getMetaData();
			System.out.println(d.getDatabaseProductName());
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}}
