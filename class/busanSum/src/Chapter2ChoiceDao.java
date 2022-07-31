
import java.sql.SQLException;
import java.util.List;

public interface Chapter2ChoiceDao {
	List<ChoiceSum> read() throws SQLException;

	ChoiceSum read(int storyId) throws SQLException;
}
