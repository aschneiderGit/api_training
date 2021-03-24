package fr.esiea.ex4A;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ApiController {

    private final UserRepository userRepository;
    private final AgifyService agifyService;
    ApiController(UserRepository userRepository, AgifyService agifyService) {
        this.userRepository = userRepository;
        this.agifyService = agifyService;
    }

    @PostMapping(path = "api/inscription")
    void inscription(@RequestBody User user) {
        userRepository.addUser(user);
    }

    @GetMapping("api/matches")
    String match(@RequestParam(name="userName") String username, @RequestParam(name="userCountry") String country) throws JSONException {
        ArrayList<User> userMatch = userRepository.getByCountry(country, userRepository.getByUsername(username, userRepository.users));
        JSONArray array = new JSONArray();
        for (User user : userMatch) {
            JSONObject item = new JSONObject();
            item.put("name", user.username);
            item.put("twitter", user.twitter);
            array.put(item);
        }
        return array.toString();
    }
}
