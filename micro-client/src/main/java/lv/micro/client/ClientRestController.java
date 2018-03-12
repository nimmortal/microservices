package lv.micro.client;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RefreshScope
@RestController
class ClientRestController {

    @Autowired
    private ServerClient serverClient;

    @Value("${message:Hello default}")
    private String message;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/")
    String getMessage() {
        return this.message;
    }

    @RequestMapping("/action")
    String getPort() {
        return serverClient.getPort();
    }

//    @RequestMapping("/remote")
//    String remote() {
//        return restTemplate().getForObject("http://numberResource/number", String.class);
//    }

    @RequestMapping("/instances")
    List<String> defaultMessage() {
        return discoveryClient.getInstances("NumberResource").stream()
                .map(i -> {
                    return String.format("%s:%d - %s", i.getHost(), i.getPort(), i.getServiceId());
                })
                .collect(Collectors.toList());
    }

}
