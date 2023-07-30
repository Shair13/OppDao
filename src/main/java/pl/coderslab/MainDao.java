package pl.coderslab;

import pl.coderslab.entity.User;
import pl.coderslab.entity.UserDao;

public class MainDao {

    public static void main(String[] args) {
        User user1 = new User("Czarek", "Czarek@czarki.com", "PassWorD123");
        User user2 = new User("Józek", "Jozef@czarki.com", "HorizonZeroDown");
        User user3 = new User("Justek", "justek123@justki.com", "Prime123");
        User user4 = new User("Lola", "lola@czarki.com", "GrandCanyon2!");
        User updateUser2 = new User(39, "Josef", "Josef@gmail.com", "SJasopfaOIAFJ");

//        UserDao ud = new UserDao();
//        ud.create(user4);
//        System.out.println(ud.read(41));
//        ud.update(updateUser2);
//        ud.delete(39);
    }
}