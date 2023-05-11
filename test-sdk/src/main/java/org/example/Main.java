package org.example;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

// todo find a way to work without this, the connector shouldn't be aware of Quarkus
@QuarkusMain
public class Main {
    public static void main(String... args) {
        Quarkus.run(MyApp.class, args);
    }

    public static class MyApp implements QuarkusApplication {
        @Override
        public int run(String... args) throws Exception {
            System.out.printf("org.example.Main.MyApp.run called.");

            Quarkus.waitForExit();

            return 0;
        }
    }
}
