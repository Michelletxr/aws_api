package com.br.Api.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AppController {


        @GetMapping(value = "welcome")
        public  String welcomeService() {
            return "Welcome to App!";
        }


}
