package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDAO;
import model.User;
import model.ValidationKey;

@WebServlet("/changepassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ChangePassword() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// 正当なフォームから送られたデータであることを確認するためのキーの生成
//		ValidationKey validationKey = new ValidationKey();
//		try {
//			Random random = new Random();
//			String randomStr = String.valueOf(random.nextLong());
//			MessageDigest validation = MessageDigest.getInstance("MD5");
//			validation.reset();
//			validation.update(randomStr.getBytes("utf8"));
//			String vkey = String.format("%032x", new BigInteger(1, validation.digest()));
//			validationKey.setValue(vkey);
//		} catch (NoSuchAlgorithmException e) {
//			e.printStackTrace();
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}
//
//		// フォーム確認キーをセッションスコープに設定
//		HttpSession session = req.getSession();
//		session.setAttribute("validationKey", validationKey);
//
//		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/profileChangeConfirm.jsp");
//		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String passwordHash = "";
		try {

			if (req.getParameter("password").equals(req.getParameter("passwordconfirm"))) {

				// パスワードのハッシュ化
				String rawPassword = req.getParameter("password");
				MessageDigest digest = MessageDigest.getInstance("SHA-256");
				digest.reset();
				digest.update(rawPassword.getBytes("utf8"));
				passwordHash = String.format("%064x", new BigInteger(1, digest.digest()));

				User user = new User();

				user.setPwdHash(passwordHash);
				user.setUserId((String) session.getAttribute("userid"));

				UserDAO userDAO = new UserDAO();
				userDAO.changepassword(user);

				resp.sendRedirect("/ActionLogger");

			} else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/changePassword.jsp");
				dispatcher.forward(req, resp);
			}

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

//		} catch (InputCheckException e1) {
//		// 表示データを用意する
//			ErrorViewData errorData = new ErrorViewData("フォームに入力された内容に問題がありました。", "入力画面に戻る",
//					"/ActionLogger/addActionForm.jsp");
//			req.setAttribute("errorData", errorData);
//		// エラー表示にフォワード
//			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/errorView.jsp");
//			dispatcher.forward(req, resp);
//		}
	}
}
