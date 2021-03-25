package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;


public class AgifyClientTest {

    @Test
    void agifyClient_testIT() throws IOException {
        String name = "Aimé";
        String country = "FR";
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.agify.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        AgifyClient agifyClient = retrofit.create(AgifyClient.class);

        Response<UserAgify> execute = agifyClient.test(name, country).execute();
        UserAgify user = execute.body();
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.name, name);
        Assertions.assertEquals(user.country_id, country);
    }
}
