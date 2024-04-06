package CNPMNC.AssetManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.engine.jdbc.connections.spi.JdbcConnectionAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
public class AssetIdGenerator implements IdentifierGenerator {

    @Override
public Object generate(SharedSessionContractImplementor session, Object object){

    String prefix = "A";

        
            try {
                JdbcConnectionAccess jdbcConnectionAccess = session.getJdbcConnectionAccess();
                Connection connection = jdbcConnectionAccess.obtainConnection();
                Statement statement = connection.createStatement();
                String query = "select count(id) as Id from Asset";

                ResultSet resultSet = statement.executeQuery(query);

                if (resultSet.next()) {
                     int id=resultSet.getInt(1)+101;
                     String generatedId = prefix + Integer.toString(id);
                     return generatedId;
                }

                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
return null;
}}
    