package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ActionDAO;
import dao.BelongsDAO;
import dao.GroupDAO;
import model.Action;
import model.Group;
import model.User;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MainPage() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// HttpSessionインタフェースのオブジェクトを取得
		HttpSession session = req.getSession();

		// useridデータをsessionスコープで保存
		String userid = (String) session.getAttribute("userid");
		String view = (String) req.getParameter("view");
		String search = (String) req.getParameter("search");

		// 活動記録
		ActionDAO actionDAO = new ActionDAO();
		List<Action> actionhistory = new ArrayList<>();
		actionhistory = actionDAO.findAll(userid);
		session.setAttribute("actionhistory", actionhistory);

		// 絞り込みの値取得(自分)
		if (view != null && view.equals("activities")) {
			List<Action> searchaction = new ArrayList<>();
			if (search != null) {
				String keyworddate = (String) req.getParameter("day");
				String keywordplace = (String) req.getParameter("place");
				actionhistory = ActionDAO.searchAll(keyworddate, keywordplace, userid);

			}
			session.setAttribute("actionhistory", actionhistory);

		}

		// グループ（管理）
		GroupDAO groupDAO = new GroupDAO();
		List<Group> group = new ArrayList<>();
		group = groupDAO.findAll(userid);
		session.setAttribute("group", group);

		// 参加グループ
		BelongsDAO belongsDAO = new BelongsDAO();
		List<Group> group2 = new ArrayList<>();
		group2 = BelongsDAO.findAll(userid);
		session.setAttribute("group2", group2);

		// 参加者一覧表示
		// サーブレットのdoGetメソッドの第一引数HttpServletRequestがリクエストパラメータの情報を持っている
		String groupid = req.getParameter("groupid");// URLからgroupid取得
		List<User> userList = new ArrayList<>();
		userList = BelongsDAO.memberAll(groupid);
		req.setAttribute("groupid", groupid);// groupMember.jspに値を渡す
		session.setAttribute("userList", userList);

		// 参加グループの活動記録
		List<Action> userActionList = new ArrayList<>();
		userActionList = ActionDAO.memberactionAll(groupid);
		session.setAttribute("userActionList", userActionList);

		// 参加グループの絞り込み
		if (view != null && view.equals("groupmember")) {
			List<Action> membersearch = new ArrayList<>();
			if (search != null) {
				String searchname = (String) req.getParameter("name");// URLからname取得
				userActionList = ActionDAO.membersearchAll(searchname, groupid);
			}
			session.setAttribute("userActionList", userActionList);
		}

		if (userid == null) {
			// MainViewを表示
			resp.sendRedirect("/ActionLogger/login");

		} else {
			// MainViewを表示
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/mainView.jsp");
			dispatcher.forward(req, resp);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
