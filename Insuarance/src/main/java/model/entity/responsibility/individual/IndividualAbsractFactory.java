package model.entity.responsibility.individual;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IndividualAbsractFactory {
	IndividualResponsibility createIndividualResponsibility(ResultSet resultSet) throws SQLException;
}
