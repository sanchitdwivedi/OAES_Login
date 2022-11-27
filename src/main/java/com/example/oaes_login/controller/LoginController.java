package com.example.oaes_login.controller;

import com.example.oaes_login.entity.User;
import com.example.oaes_login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/userID")
    public ResponseEntity<Object> loginByUserID(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(loginService.authenticateByUserID(user.getUserID(), user.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/email")
    public ResponseEntity<Object> loginByEmail(@RequestBody User user) throws Exception {
        return new ResponseEntity<>(loginService.authenticateByEmail(user.getEmail(), user.getPassword()), HttpStatus.OK);
    }
}
