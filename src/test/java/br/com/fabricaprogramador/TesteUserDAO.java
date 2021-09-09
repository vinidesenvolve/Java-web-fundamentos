package br.com.fabricaprogramador;

import br.com.fabricaprogramador.pesistence.entity.User;

public class TesteUserDAO {
    
    public static void main(String[] args){

        User user = new User();
        user.setName("Antonio Vivaldi");
        user.setLogin("vivaldi");
        user.setPassword("1234");

    }
}
