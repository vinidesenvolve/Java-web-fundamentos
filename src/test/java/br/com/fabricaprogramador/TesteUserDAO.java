package br.com.fabricaprogramador;

import br.com.fabricaprogramador.pesistence.entity.User;
import br.com.fabricaprogramador.pesistence.jdbc.UserDAO;
import java.util.List;

public class TesteUserDAO {

  public static void main(String[] args) {
    authUser();
  }

  private static void authUser() {
    UserDAO userDAO = new UserDAO();
    User user = new User();

    user.setLogin("moza");
    user.setPassword("1234");

    System.out.println(userDAO.auth(user));
  }

  private static void saveUser() {
    User user = new User();

    user.setName("Mozart");
    user.setLogin("moza");
    user.setPassword("1234");

    UserDAO userDAO = new UserDAO();
    userDAO.save(user);
  }

  private static void updateUser() {
    User user = new User();

    user.setId(1);
    user.setName("Antônio Vivaldi");
    user.setLogin("vival");
    user.setPassword("123");

    UserDAO userDAO = new UserDAO();
    userDAO.update(user);
  }

  private static void deleteUser() {
    UserDAO userDAO = new UserDAO();
    userDAO.delete(1);
  }

  private static void findUserById() {
    UserDAO userDAO = new UserDAO();
    User user = userDAO.findById(2);

    System.out.println(user.toString());
  }

  private static void findUsers() {
    UserDAO userDAO = new UserDAO();
    List<User> users = userDAO.findAll();

    users.stream().forEach(user -> System.out.println(user.getName()));
  }
}
