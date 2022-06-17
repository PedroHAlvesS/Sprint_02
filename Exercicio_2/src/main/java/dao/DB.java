package dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DB  {
    private DataSource dataSource;

    public DB(String user, String password) {
        String url = "jdbc:mysql://localhost:3306/sprint_02?useTimezone=true&serverTimezone=UTC";
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        comboPooledDataSource.setMaxPoolSize(2);
        this.dataSource = comboPooledDataSource;
    }

    public Connection initConnection() {
        try {
            return this.dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
