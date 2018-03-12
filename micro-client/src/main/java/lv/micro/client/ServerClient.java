package lv.micro.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "${service.backend.name}", fallback = ServerFallback.class)
interface ServerClient {
    @GetMapping(value = "/action")
    String getPort();
}