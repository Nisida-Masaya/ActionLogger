package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Action;
import model.Group;
import model.User;

public class GroupDAO {
	// データベース接続に使用する情報
	private final static String JDBC_URL = "jdbc:h2:tcp://localhost/~/h2db/ActionLogger";
	private final static String DB_USER = "sa";
	private final static String DB_PASS = "";

	public static boolean save(Group group, String userid) {
		// データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {

			// INSERT文の準備(idは自動連番なので指定しなくてよい）
			// MANAGEIDにはユーザID
			String sql = "INSERT INTO MANAGEMENT " + "( MGT_GROUPID, GROUPNAME, MANAGEID ) " + "VALUES ( ?, ?, ? )";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// INSERT文中の「?」に使用する値を設定しSQLを完成
			pStmt.setString(1, group.getGroupid());
			pStmt.setString(2, group.getGroupname());
			pStmt.setString(3, userid);

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
	
	public List<Group> findAll(String userid){
		List<Group> groupList = new ArrayList();
		
		//データベース接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			//SELECTの準備
			String sql = "SELECT GROUPNAME, MGT_GROUPID FROM MANAGEMENT"
					+ " WHERE MANAGEID=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userid);
			//結果取得
			ResultSet rs = pStmt.executeQuery();
			
			//レコード内容
			//GROUPインスタンスに設定、ArrayListに追加
			while(rs.next()) {
				Group group = new Group();
				group.setGroupname(rs.getString("groupname"));
				group.setGroupid(rs.getString("MGT_GROUPID"));
				groupList.add(group);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return null;
		}
		return groupList;
	}	
	
	
}
