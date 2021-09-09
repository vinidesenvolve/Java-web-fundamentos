package br.com.fabricaprogramador;

import br.com.fabricaprogramador.pesistence.entity.User;
import br.com.fabricaprogramador.pesistence.jdbc.UserDAO;

public class TesteUserDAO {

  public static void main(String[] args) {
      saveUser();
  }

  private static void saveUser() {
    User user = new User();
    
    user.setName("Antonio Vivaldi");
    user.setLogin("vivaldi");
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
 
}
