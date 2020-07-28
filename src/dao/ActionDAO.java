package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Action;
import model.User;
import servlet.AddAction;

public class ActionDAO {
	// データベース接続に使用する情報
		private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/h2db/ActionLogger";
		private final String DB_USER = "sa";
		private final String DB_PASS = "";
		
		public Action get(String actionId) {
			Action action = null;

			// データベース接続
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

				// SELECT文の準備
				String sql = "SELECT * FROM ACTION WHERE actionid = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, actionId);

				// SELECTを実行
				ResultSet rs = pStmt.executeQuery();

				// SELECT文の結果をactionに格納
				while (rs.next()) {
					action = new Action();
					action.setActionId(rs.getString("ActionId"));
					action.setActionId(rs.getString("Day"));
					action.setStarttime(rs.getString("Starttime"));
					action.setFinishtime(rs.getString("Finishtime"));
					action.setPlace(rs.getString("Place"));
					action.setReason(rs.getString("Reason"));
					action.setRemark(rs.getString("Remark"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return action;
		}
		
		public boolean save(Action action) {
			// データベース接続
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

				// INSERT文の準備(idは自動連番なので指定しなくてよい）
				String sql = "INSERT INTO action " + "( actionId, day, starttime, finishtime, place, reason, remark ) "
						+ "VALUES ( ?, ?, ?, ?, ?, ?, ? )";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// INSERT文中の「?」に使用する値を設定しSQLを完成
				pStmt.setString(1, action.getActionId());
				pStmt.setString(2, action.getDay());
				pStmt.setString(3, action.getStarttime());
				pStmt.setString(4, action.getFinishtime());
				pStmt.setString(5, action.getPlace());
				pStmt.setString(6, action.getReason());
				pStmt.setString(7, action.getRemark());

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
}
