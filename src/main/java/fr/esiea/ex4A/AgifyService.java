package fr.esiea.ex4A;

import org.json.JSONException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AgifyService {
    @POST("api/inscription")
    Call<User> inscription(@RequestBody User user);

    @GET("api/matches")
    String match(@RequestParam(name="userName") String username, @RequestParam(name="userCountry") String country);


    }
