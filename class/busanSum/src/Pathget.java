

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.co.green.BusanUtil;


public class Pathget {
	public String[] getPathAll(String id, int pathNum) throws SQLException {
		String[] savepath = null;
		try (Connection conn = BusanUtil.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Busan.savehere");
				ResultSet rs = pstmt.executeQuery();) {
			
			String yourSave1 = "";
			String yourSave2 = "";
			while (rs.next()) {
				if (id.equals(rs.getString("userId"))) {
					yourSave1 = rs.getString("storyPath1");
					yourSave2 = rs.getString("storyPath2");
				}
			}
			
			yourSave1 = yourSave1.replace(" ", "").replace("[", "").replace("]", "");
			yourSave2 = yourSave2.replace(" ", "").replace("[", "").replace("]", "");
			String[] saveArr1 = yourSave1.split(",");
			String[] saveArr2 = yourSave2.split(",");
			
			if(pathNum == 1) {
				savepath = saveArr1;
			} else if(pathNum == 2) {
				savepath = saveArr2;
			}
		}
		return savepath;
	}
	
	public String[] getPath1(String id) throws SQLException {
		return getPathAll(id, 1);
	}
	
	public String[] getPath2(String id) throws SQLException {		
		return getPathAll(id, 2);
	}
	
	public static void main(String[] args) {
		
	}
}
