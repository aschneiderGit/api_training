package fr.esiea.ex4A;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@RestController
public class ApiController {

    private final AgifyService agifyService;

    ApiController(AgifyService agifyService) {
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
}
