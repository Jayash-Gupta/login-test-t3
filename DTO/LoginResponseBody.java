package com.picafe.team_3.DTO;

import java.util.logging.Logger;
import lombok.Data;

@Data
public class LoginResponseBody {

    private String message;
    private String token;
    private String error;

    private static final Logger logger = Logger.getLogger(LoginRequestBody.class.getName());

    public LoginResponseBody(String token, String message) {
        logger.info("Login Response Body object created");
        this.token = token;
        this.message = message;
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public String getToken() {
        return token;
    }

    public String getError() {
        return error;
    }
}
