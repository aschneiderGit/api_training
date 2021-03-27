package fr.esiea.ex4A;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class ApiController {

<<<<<<< HEAD
    private final AgifyService agifyService;

    ApiController(AgifyService agifyService) {
=======
    private final UserRepository userRepository;
    private final AgifyService agifyService;
    ApiController(UserRepository userRepository, AgifyService agifyService) {
        this.userRepository = userRepository;
>>>>>>> 0194137... test retrofit done
        this.agifyService = agifyService;
    }

    @PostMapping(path = "api/inscription")
    void inscription(@RequestBody User user) throws IOException {
        agifyService.addUser(user);
    }

    @GetMapping("api/matches")
    String match(@RequestParam(name="userName") String userName, @RequestParam(name="userCountry") String userCountry) throws JSONException {
        ArrayList<User> userMatch = agifyService.matchFor(userName, userCountry);
        JSONArray array = new JSONArray();
        for (User user : userMatch) {
            JSONObject item = new JSONObject();
            item.put("name", user.username);
            item.put("twitter", user.twitter);
            array.put(item);
        }
        return array.toString();
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
