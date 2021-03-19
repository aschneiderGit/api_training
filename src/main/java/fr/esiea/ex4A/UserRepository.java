package fr.esiea.ex4A;

import fr.esiea.ex4A.hello.HelloData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Locale;

@Repository
public class UserRepository {
    final ArrayList<User> users = new ArrayList<User>() ;

     public void addUser(User user) {
        users.add(user);
    }
}
