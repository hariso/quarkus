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
            new Thread(() -> {
                // todo this is soooo dirty...
                // ... but it works!
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int port = 9000; // default
                System.out.printf("1|1|tcp|localhost:%d|grpc%n", port);
            }).start();

            Quarkus.waitForExit();

            return 0;
        }
    }
}
