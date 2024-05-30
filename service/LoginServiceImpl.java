package com.picafe.team_3.service;

import com.picafe.team_3.DTO.LoginRequestBody;
import com.picafe.team_3.DTO.LoginResponseBody;
import com.picafe.team_3.model.Login;
import com.picafe.team_3.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger logger = Logger.getLogger(LoginServiceImpl.class.getName());

    @Autowired
    private LoginRepository storeRepository;

    @Autowired
    private JwtService jwtService;

    @Override
    public LoginResponseBody login(LoginRequestBody loginRequest) {
        logger.info("Login request received for username: " + loginRequest.getEmployeeId());

        Optional<Login> empOpt = storeRepository.findByEmployeeId(loginRequest.getEmployeeId());

        if (empOpt.isPresent()) {
            Login emp = empOpt.get();
            logger.info("Employee found: " + emp.getEmployeeId());

            if (emp.getEmployeePassword().equals(loginRequest.getEmployeePassword())) {
                logger.info("Login successful for username: " + loginRequest.getEmployeeId());

                String token = authenticateToken(loginRequest.getEmployeeId(), emp.getEmployeeDesignation());
                return new LoginResponseBody(token, "Login Successful");
            }

            else {
                logger.warning("Invalid credentials for username: " + loginRequest.getEmployeeId());
                throw new InvalidCredentialsException("Invalid Credentials");
            }
        } else {
            logger.warning("Employee Not Found: " + loginRequest.getEmployeeId());
            throw new UserNotFoundException("Employee Not Found");
        }

    }

    private String authenticateToken(int employeeId, String employeeDesignation) {
        return jwtService.generateToken(employeeId, employeeDesignation);
    }

}
