package com.example.oaes_login.controller;

import com.example.oaes_login.entity.User;
import com.example.oaes_login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("")
    public ResponseEntity<Object> login(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(loginService.authenticateByUserID(user.getUserID(), user.getPassword()), HttpStatus.OK);
    }
}