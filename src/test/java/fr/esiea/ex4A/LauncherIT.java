package fr.esiea.ex4A;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class LauncherIT {

    @Test
    void agifyClientBean_test(){
        Launcher mock = new Launcher();

        AgifyClient agifyClient = mock.agifyClient();

        assertNotNull(agifyClient);
    }

}
