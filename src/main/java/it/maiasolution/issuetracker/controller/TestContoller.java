package it.maiasolution.issuetracker.controller;

import java.security.Principal;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestContoller {
    
    
    @GetMapping("/headers")
    public ResponseEntity<String> hello(@RequestHeader Map<String, String> headers, Principal principal) {

        log.info("incoming request...");
        headers.forEach((key, value) -> {
            log.info(String.format("Header '%s' = %s", key, value));
        });

        log.info("authenticated user : {}", ( principal != null ) ? principal.getName() : "NA");

        return ResponseEntity.ok("Hello World !");
    }
}
