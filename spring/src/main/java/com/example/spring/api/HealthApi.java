package com.example.spring.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HealthApi {

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok().build();
    }
}
