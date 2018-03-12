package lv.micro.client;

import org.springframework.stereotype.Component;

@Component
public class ServerFallback implements ServerClient {
    @Override
    public String getPort() {
        return "unavailable";
    }
}