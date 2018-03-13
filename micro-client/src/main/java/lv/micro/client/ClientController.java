package lv.micro.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@RefreshScope
@Controller
class ClientController {

    @Autowired
    private ServerClient serverClient;

    @Value("${message:Hello default}")
    private String message;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/action")
    String getPort() {
        return serverClient.getPort();
    }

    @GetMapping("/")
    public String welcome(ModelMap model) {
        model.put("message", this.message);
        return "welcome";
    }

    @GetMapping("/instances")
    List<String> defaultMessage() {
        return discoveryClient.getInstances("NumberResource").stream()
                .map(i -> {
                    return String.format("%s:%d - %s", i.getHost(), i.getPort(), i.getServiceId());
                })
                .collect(Collectors.toList());
    }

}
