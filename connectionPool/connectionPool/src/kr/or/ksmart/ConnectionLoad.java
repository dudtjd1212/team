package kr.or.ksmart;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/")
public class ConnectionLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ConnectionLoad() {
        super();        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String connectionInfo = "";
		String getConnectionInfo = "";
		try{			
			Context context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/connCall");
			connectionInfo = dataSource.toString();
			getConnectionInfo = dataSource.getConnection().toString();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		PrintWriter out = response.getWriter();
		out.write("Served at: " + request.getContextPath()+"<br>");
		out.write("dataSource info : " + connectionInfo+"<br>");
		out.write("connection info : " +getConnectionInfo);
		out.close();
		out.flush();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
