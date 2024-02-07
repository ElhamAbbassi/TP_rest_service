package ch.admin.zas.TP_rest_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api")
public class TpRestService {

    @GetMapping(value = "/hello", produces = "application/json")
    public String greet(@RequestParam(value = "name", required=false, defaultValue = "world") String insName) {
        log.info("greet() called");
        return "{ \"title\": \"" + String.format("Hello %s!", insName) + "\"}";
    }
}
