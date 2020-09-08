package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Action;
import model.Belongs;
import model.Group;
import model.User;

public class BelongsDAO {
	// データベース接続に使用する情報
	private final static String JDBC_URL = "jdbc:h2:tcp://localhost/~/h2db/ActionLogger";
	private final static String DB_USER = "sa";
	private final static String DB_PASS = "";

	public boolean isgroup(Belongs belongs, String userid) {
		// データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文の準備(idは自動連番なので指定しなくてよい）
			String sql = " INSERT INTO BELONGS " + " ( MGT_GROUPID, USERID ) " + " VALUES (?, ?) ";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, belongs.getGroupid());
			pStmt.setString(2, userid);

			// INSERT文を実行
			int result = pStmt.executeUpdate();
			if (result != 1) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static List<Group> findAll(String userid) {
		List<Group> groupList = new ArrayList();

		// データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECTの準備
			String sql = "SELECT M.GROUPNAME FROM MANAGEMENT as M, BELONGS as B"
					+ " WHERE M.MGT_GROUPID = B.MGT_GROUPID and B.USERID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userid);
			// 結果取得
			ResultSet rs = pStmt.executeQuery();

			// レコード内容
			// Belongsインスタンスに設定、ArrayListに追加
			while (rs.next()) {
				Group group = new Group();
				group.setGroupname(rs.getString("groupname"));
				groupList.add(group);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		return groupList;
	}

	public static List<User> memberAll(String groupid) {
		List<User> userList = new ArrayList();

		// データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			// SELECTの準備
			String sql = "select U.USERID, U.NAME from USER as U, BELONGS as B "
					+ "where U.USERID = B.USERID and B.MGT_GROUPID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, groupid);
			// 結果取得
			ResultSet rs = pStmt.executeQuery();

			// レコード内容
			// Belongsインスタンスに設定、ArrayListに追加
			while (rs.next()) {
				User user = new User();
				user.setUserId(rs.getString("userid"));
				user.setName(rs.getString("name"));
				userList.add(user);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		return userList;
	}

}
