package com.picafe.team_3.service;

import com.picafe.team_3.DTO.LoginRequestBody;
import com.picafe.team_3.DTO.LoginResponseBody;

public interface LoginService {

    LoginResponseBody login(LoginRequestBody loginReq);

}
