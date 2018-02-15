package lv.micro.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RefreshScope
@RestController
class MessageRestController {

    @Value("${message:Hello default}")
    private String message;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    String getMessage() {
        return this.message;
    }

    @RequestMapping("/instances")
    List<String> defaultMessage() {
        return discoveryClient.getInstances("client").stream()
                .map(i -> {
                    return String.format("%s:%d - %s", i.getHost(), i.getPort(), i.getServiceId());
                })
                .collect(Collectors.toList());
    }

}