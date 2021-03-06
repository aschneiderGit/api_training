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
        for(Map.Entry<String, UserAgify> userA : userAs.entrySet()) {
            if (userA.getValue().age > userAs.get(user.getId()).age - 4 && userA.getValue().age < userAs.get(user.getId()).age + 4 ) {
                User userSelect = users.get(userA.getKey());
                if (userSelect.sex.equals(user.sexPref) && userSelect.sexPref.equals(user.sex) ) {
                    filtredUsers.add(userSelect);
                }
            }
        }
        return  filtredUsers;
    }
}
