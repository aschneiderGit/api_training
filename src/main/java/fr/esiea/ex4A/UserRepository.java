package fr.esiea.ex4A;

import fr.esiea.ex4A.hello.HelloData;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Repository
public class UserRepository {
    final HashMap<String, User> users = new HashMap<String, User>() ;
    final HashMap<String, UserAgify> userAs = new HashMap<String, UserAgify>();
    private final Integer AGE_GAP = 4;

     public void addUser(User user, UserAgify userA) {
        users.put(user.getId(), user);
        userAs.put(user.getId(), userA);
    }

    public ArrayList<User> matchUsers(User user){

        ArrayList<User> filtredUsers = new ArrayList<User>();
        int age = userAs.get(user.getId()).age;
        String sexPref = user.sexPref;
        String mySex = user.sex;
        for(Map.Entry<String, UserAgify> userA : userAs.entrySet()) {
            if (userA.getValue().age > age - 4 && userA.getValue().age < age + 4 )
            {
                User userSelect = users.get(userA.getKey());
                if (userSelect.sex.equals(sexPref) && userSelect.sexPref.equals(mySex) )
                {
                    filtredUsers.add(userSelect);
                }
            }
        }
        return  filtredUsers;
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
