package com.picafe.team_3.controllers;

import com.picafe.team_3.DTO.LoginRequestBody;
import com.picafe.team_3.DTO.LoginResponseBody;
import com.picafe.team_3.service.LoginService;
import com.picafe.team_3.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1")
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginRequestBody.class.getName());

    @Autowired
    private LoginService empService;

    @Autowired
    private JwtService jwtService;

    @PostMapping(value = "/login", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponseBody> login(@RequestBody LoginRequestBody loginReq) {
        LoginResponseBody response = empService.login(loginReq);
        logger.info("Reached to the server");
        return ResponseEntity.ok(response);
    }

}
