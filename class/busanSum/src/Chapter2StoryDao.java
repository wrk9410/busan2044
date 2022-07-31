
import java.sql.SQLException;
import java.util.List;



public interface Chapter2StoryDao {
		List<Story> read() throws SQLException;
		Story read(int storyId) throws SQLException;
}
