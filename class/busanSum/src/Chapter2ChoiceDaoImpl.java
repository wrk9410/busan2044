

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.green.BusanUtil;

public class Chapter2ChoiceDaoImpl implements Chapter2ChoiceDao {

	private ChoiceSum resultMapping(ResultSet rs) throws SQLException {

		int choiceId = rs.getInt("choiceId");
		String choiceNum = rs.getString("choiceNum");
		String choiceMain = rs.getString("choiceMain");

		return new ChoiceSum(choiceId, choiceNum, choiceMain);
	}

	@Override
	public List<ChoiceSum> read() throws SQLException {

		String query = "Select * From origin_chapter2_choice";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ChoiceSum> list = new ArrayList<>();

		try {
			conn = BusanUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(resultMapping(rs));
			}
		} finally {
			BusanUtil.closeRS(rs);
			BusanUtil.closeStmt(pstmt);
			BusanUtil.closeConn(conn);
		}
		return list;
	}

	@Override
	public ChoiceSum read(int choiceId) throws SQLException {

		String query = "SELECT * FROM origin_chapter2_choice WHERE choiceId = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = BusanUtil.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, choiceId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				return resultMapping(rs);
			}
		} finally {
			BusanUtil.closeRS(rs);
			BusanUtil.closeStmt(pstmt);
			BusanUtil.closeConn(conn);
		}
		return null;
	}
}
