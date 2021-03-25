package fr.esiea.ex4A;


import org.springframework.web.bind.annotation.RequestParam;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface AgifyClient {

    @GET("?")
    Call<UserAgify> test(@Query("name") String username, @Query("country_id") String country);


    }
