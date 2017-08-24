package model.entity.responsibility.property;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface PropertyAbstractFactory {
	PropertyResponsibility createPropertyResponsibility(ResultSet resultSet) throws SQLException;
}
