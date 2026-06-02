package motores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreMotorSQL implements MotorSQL{
//DATOS DE LA BASE DE DATOS
    private static final String URL = "jdbc:postgresql://enma-contin-dam2.c58saw2qyczl.us-east-1.rds.amazonaws.com:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456789";

    private Connection connection;
    @Override
    public void connect() {
        try{
            //Instalar driver para PostgreSQL (no recuerdo como añadirlo)
            Class.forName("org.postresql.Driver");
            this.connection = DriverManager.getConnection(URL,USER, PASSWORD);
            System.out.println("Conexion exitosa a la base de datos de PostgreSQL");
        }catch (Exception e){
            System.out.println("Error al conectar a la base de datos de PostgreSQL: "+e.getMessage());
        }

    }

    @Override
    public void disconnect() {
        //desconectamos si la conexion existe y no está ya cerrada
        try {
            if(this.connection != null && !this.connection.isClosed()){

                this.connection.close();
                System.out.println("Desconexión exitosa de la base de datos PostgreSQL");
            }
        }catch(SQLException e){
            System.out.println("Error al desconectar de la base de datos PostgreSQL: " + e.getMessage());
        }
    }

    @Override
    public ResultSet executeQuery(String sql) {
        try{
            Statement stmt = this.connection.createStatement();
            return stmt.executeQuery(sql);
        }catch(SQLException e){
            System.out.println("Error al ejecutar la consulta SQL: " + e.getMessage());
            return null;
        }
    }

    @Override
    public int executeUpdate(String sql) {
        try{
            Statement stmt = this.connection.createStatement();
            return stmt.executeUpdate(sql);
        }catch(SQLException e){
            System.out.println("Error al ejecutar la actualización SQL: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public Connection getConnection() {
        return this.connection;
    }
}
