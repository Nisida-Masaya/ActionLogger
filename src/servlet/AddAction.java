package servlet;

import static model.InputChecker.checkLongInput;
import static model.InputChecker.checkMailAddress;
import static model.InputChecker.checkPhoneNumber;

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

import model.Action;
import model.ErrorViewData;
import model.InputCheckException;
import model.User;
import model.ValidationKey;

@WebServlet("/addaction")
public class AddAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddAction() {
		super();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 正当なフォームから送られたデータであることを確認するためのキーの生成
		ValidationKey validationKey = new ValidationKey();
		try {
			Random random = new Random();
			String randomStr = String.valueOf(random.nextLong());
			MessageDigest validation = MessageDigest.getInstance("MD5");
			validation.reset();
			validation.update(randomStr.getBytes("utf8"));
			String vkey = String.format("%032x", new BigInteger(1, validation.digest()));
			validationKey.setValue(vkey);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// フォーム確認キーをセッションスコープに設定
		HttpSession session = req.getSession();
		session.setAttribute("validationKey", validationKey);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addActionForm.jsp");
		dispatcher.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();

		// フォームから送られた確認キーが保存したものと一致するか確認
		ValidationKey validationKey = (ValidationKey) session.getAttribute("validationKey");
		if (!req.getParameter("vKey").equals(validationKey.getValue())) {
			// 一致しなかったので、セッションスコープに保存したキーを破棄し、エラーページに
			session.removeAttribute("validationKey");
			// 表示データを用意する
			ErrorViewData errorData = new ErrorViewData("問題が発生しました。", "トップに戻る", "/ActionLogger/");
			req.setAttribute("errorData", errorData);
			// エラー表示にフォワード
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/errorView.jsp");
			dispatcher.forward(req, resp);
			return;
		}

		Action action = new Action();
		try {
			action.setDay(checkLongInput(req.getParameter("day")));
			action.setStarttime(checkLongInput(req.getParameter("starttime")));
			action.setFinishtime(checkLongInput(req.getParameter("finishtime")));
			action.setPlace(checkPhoneNumber(req.getParameter("place")));
			action.setReason(checkMailAddress(req.getParameter("reason")));
			action.setRemark(checkMailAddress(req.getParameter("remark")));

			// userオブジェクトをセッションスコープに一旦保存（DBに入れるのはConfirmの後）
			session.setAttribute("actionToAdd", action);

			// 確認画面にリダイレクト
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addActionConfirm.jsp");
			dispatcher.forward(req, resp);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (InputCheckException e1) {
			// 表示データを用意する
			ErrorViewData errorData = new ErrorViewData("フォームに入力された内容に問題がありました。", "入力画面に戻る",
					"/ActionLogger/addActionForm.jsp");
			req.setAttribute("errorData", errorData);
			// エラー表示にフォワード
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/errorView.jsp");
			dispatcher.forward(req, resp);
		}
	}
}
