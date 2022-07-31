

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.BusanUtil;

public class NpcDao {
	public int getNpcSkill(Connection conn, int npc_id) throws SQLException {
		String query = "select * from npc_table where npc_id = ?"; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, npc_id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt("npc_skill");
			}
			return result;
		} finally {
			BusanUtil.closeRS(rs);
			BusanUtil.closeStmt(pstmt);
		}
	}
	public int getNpcId(Connection conn, String npc_name) throws SQLException {
		String query = "select * from npc_table where npc_name = ?"; 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, npc_name);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt("npc_id");
			}
			return result;
		} finally {
			BusanUtil.closeRS(rs);
			BusanUtil.closeStmt(pstmt);
		}
	}
}
