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

    public ArrayList<User> getByUsername(String username, ArrayList<User> userList){
        ArrayList<User> matchUsers = new ArrayList<User>();
        System.out.println("username");
        for (User u: userList) {
            if (u.username.equals(username))
            {
                matchUsers.add(u);
                System.out.println("add name");
            }
        }
        return matchUsers;
    }

    public ArrayList<User> getByCountry(String country, ArrayList<User> userList){
        ArrayList<User> matchUsers = new ArrayList<User>();
        System.out.println("country");
        for (User u: userList) {
            if (u.country.equals(country))
            {
                matchUsers.add(u);
                System.out.println("add country");
            }
        }
        return matchUsers;
    }
}
