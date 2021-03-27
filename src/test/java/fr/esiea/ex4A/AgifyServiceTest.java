package fr.esiea.ex4A;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;


public class AgifyServiceTest {

    @Test
    void agifyService_testIT() throws IOException {
        String name = "Aimé";
        String country = "FR";
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.agify.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        AgifyService agifyService = retrofit.create(AgifyService.class);

        Response<UserAgify> execute = agifyService.test(name, country).execute();
        UserAgify user = execute.body();
        Assertions.assertNotNull(user);
        Assertions.assertEquals(user.name, name);
        Assertions.assertEquals(user.country_id, country);
    }
}
