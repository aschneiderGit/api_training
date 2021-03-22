package fr.esiea.ex4A;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ApiController {

    private final UserRepository userRepository;
    ApiController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "api/inscription")
    void inscription(@RequestBody User user) {
        userRepository.addUser(user);
        System.out.println(user);
        System.out.println(userRepository.users.size());
        System.out.println(userRepository.users.get(userRepository.users.size()-1));
    }

    @GetMapping("api/matches")
    String match(@RequestParam(name="userName") String username, @RequestParam(name="userCountry") String country) throws JSONException {
        System.out.println(country);
        System.out.println(username);
        ArrayList<User> userMatch = userRepository.getByCountry(country, userRepository.getByUsername(username, userRepository.users));
        JSONArray array = new JSONArray();
        for (User user : userMatch) {
            JSONObject item = new JSONObject();
            item.put("name", user.username);
            item.put("twitter", user.twitter);
            array.put(item);
        }
        return array.toString() ;

    }
}
