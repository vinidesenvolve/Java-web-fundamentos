package br.com.fabricaprogramador.pesistence.jdbc;

import br.com.fabricaprogramador.pesistence.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

  private Connection con = ConnectionFactory.getConnection();

  public User auth(User userAuth) {
    String sql = "select * from users where login=? and password=?";

    try {
      PreparedStatement statement = con.prepareStatement(sql);

      statement.setString(1, userAuth.getLogin());
      statement.setString(2, userAuth.getPassword());

      ResultSet result = statement.executeQuery();

      if (result.next()) {
        User user = new User();

        user.setId(result.getInt("id"));
        user.setName(result.getString("name"));
        user.setLogin(result.getString("login"));
        user.setPassword(result.getString("password"));

        return user;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return null;
  }

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

      if (result.next()) {
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

  public List<User> findAll() {
    String sql = "select * from users";
    List<User> users = new ArrayList<>();

    try {
      PreparedStatement statement = con.prepareStatement(sql);

      ResultSet result = statement.executeQuery();

      while (result.next()) {
        User user = new User();

        user.setId(result.getInt("id"));
        user.setName(result.getString("name"));
        user.setLogin(result.getString("login"));
        user.setPassword(result.getString("password"));

        users.add(user);
      }

      statement.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    return users;
  }
}
