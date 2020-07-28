package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addactionconfirm")
public class AddActionConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddActionConfirm() {
		super();
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		// DBへの保存が成功したものとして、ホームに遷移
		resp.sendRedirect("/ActionLogger/dashboard");
	}
}
