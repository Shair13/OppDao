package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

public class MainDao {

    public static void main(String[] args) {
//        User user1 = new User("Czarek", "Czarek@czarki.com", "PassWorD123");
//        User user2 = new User("Józek", "Jozef@czarki.com", "HorizonZeroDown");
//        User user3 = new User("Justek", "justek123@czarki.com", "Prime123");
//        User user4 = new User("Lola", "lola@czarki.com", "GrandCanyon2!");
//
        UserDao ud = new UserDao();
//        ud.create(user1);
//        ud.create(user2);
//        ud.create(user3);
//        ud.create(user4);

        User user5 = new User(14,"Lola222", "lola2@czarki.com222", "HasloMasl222o");
//        ud.create(user5);
//        ud.update(user5);
//            ud.delete(13);
        ud.findAll();
    }
}