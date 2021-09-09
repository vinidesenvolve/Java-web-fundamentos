package br.com.fabricaprogramador.pesistence.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.fabricaprogramador.pesistence.entity.User;

public class UserDAO {
    private Connection con = ConnectionFactory.getConnection();
    
    public void save(User user) {
        String sql = "insert into users (name, login, password) values (?,?,?)";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
              e.printStackTrace();
        }
    }

    public void update(User user) {
        String sql = "update users set name=?, login=?, password=? where id=?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
              e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String sql = "delete from users where id=?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);

            statement.execute();
            statement.close();

        } catch (SQLException e) {
              e.printStackTrace();
        }
    }

    public User findById(Integer id) {
        String sql = "select * from users where id=?";

        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            if(result.next()) {
                User user = new User();
                user.setId(result.getInt("id"));
                user.setName(result.getString("name"));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));

                return user;
            }

            statement.close();
        } catch (SQLException e) {
              e.printStackTrace();
        }

        return null;
    }
}
