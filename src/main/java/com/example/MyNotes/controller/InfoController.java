package com.example.MyNotes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;
@RestController
public class InfoController {
    @GetMapping("/api/info")
    public Map<String, String> getInfo() {
        Map<String, String> response = new HashMap<>();
        response.put("app", "MyNotes Application");
        response.put("status", "Running Successfully");
        response.put("environment", "AWS Elastic Beanstalk");
        response.put("version", "v1.0");
        return response;
    }
}

