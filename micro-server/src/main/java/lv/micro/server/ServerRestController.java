package lv.micro.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RefreshScope
@RestController
class ServerRestController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/action")
    String getPort() {
        return port;
    }

}