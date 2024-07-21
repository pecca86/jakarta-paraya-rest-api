package org.eclipse.jakarta.hello.services;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.jakarta.hello.configs.annotations.Timed;

@ApplicationScoped // CDI Bean (Singleton)
public class GreetingService {

    @Timed
    public String greet(String language) {
        String result = "Hello %s";

        return switch (language) {
            case "es" -> String.format(result, "mundo");
            case "fr" -> String.format(result, "monde");
            case "de" -> String.format(result, "Welt");
            default -> String.format(result, "world");
        };
    }
}
