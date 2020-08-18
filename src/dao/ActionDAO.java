package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Action;
import model.User;

public class ActionDAO {
	// データベース接続に使用する情報
		private final static String  JDBC_URL = "jdbc:h2:tcp://localhost/~/h2db/ActionLogger";
		private final static String  DB_USER = "sa";
		private final static String  DB_PASS = "";
				
		public static  boolean save(Action action, String userid) {
			// データベース接続
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

				// INSERT文の準備(idは自動連番なので指定しなくてよい）
				String sql = "INSERT INTO action " + "( day, starttime, finishtime, place, reason, remark, userid ) "
						+ "VALUES ( ?, ?, ?, ?, ?, ?, ? )";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// INSERT文中の「?」に使用する値を設定しSQLを完成
//				pStmt.setString(1, action.getActionId());
				pStmt.setString(1, action.getDay());
				pStmt.setString(2, action.getStarttime());
				pStmt.setString(3, action.getFinishtime());
				pStmt.setString(4, action.getPlace());
				pStmt.setString(5, action.getReason());
				pStmt.setString(6, action.getRemark());
				pStmt.setString(7, userid);

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
		
		public List<Action> findAll(String userid){
			List<Action> actionList = new ArrayList();
			
			//データベース接続
			try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
				//SELECTの準備
				String sql = "SELECT * FROM ACTION"
						+ " WHERE USERID=?"
						+ " ORDER BY DAY DESC";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				pStmt.setString(1, userid);
				//結果取得
				ResultSet rs = pStmt.executeQuery();
				
				//レコード内容
				//ACTIONHISTORYインスタンスに設定、ArrayListに追加
				while(rs.next()) {
					Action action = new Action();
					action.setDay(rs.getString("Day"));
					action.setStarttime(rs.getString("Starttime"));
					action.setFinishtime(rs.getString("Finishtime"));
					action.setPlace(rs.getString("Place"));
					action.setReason(rs.getString("Reason"));
					action.setRemark(rs.getString("Remark"));
					action.setUserId(rs.getString("Userid"));
					actionList.add(action);
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
				return null;
			}
			return actionList;
		}		
}

