package motores;

import java.sql.Connection;
import java.sql.ResultSet;

public interface MotorSQL {
    void connect();
    void disconnect();
    ResultSet executeQuery(String sql);
    int executeUpdate(String sql);
    Connection getConnection();
}
