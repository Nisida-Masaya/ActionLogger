package servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class profileCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		//httpsessionのインタフェースのオブジェクト取得
		HttpSession session = request.getSession();
		//sessionで保存
		String userid = (String) session.getAttribute("userid");
		String password = (String) session.getAttribute("password");
	}
}

