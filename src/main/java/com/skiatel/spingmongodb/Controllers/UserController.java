package com.skiatel.spingmongodb.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @GetMapping("/hola")
    public ResponseEntity<String> hola(){
        return ResponseEntity.ok("Hola");
    }
}
