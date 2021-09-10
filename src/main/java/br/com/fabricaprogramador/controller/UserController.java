package br.com.fabricaprogramador.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricaprogramador.pesistence.entity.User;
import br.com.fabricaprogramador.pesistence.jdbc.UserDAO;
//http://localhost:8080/fabricaweb/usercontroller
@WebServlet("/usercontroller")
public class UserController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User();

        user.setName(name);
        user.setLogin(login);
        user.setPassword(password);

        UserDAO userDAO = new UserDAO();
        userDAO.save(user);
  }
}
