package support;

import io.cucumber.java.After;

import static support.DriverFactory.*;

public class Hooks {

    @After
    public void after() {
        closeDriver();
    }
}
