package com.picafe.team_3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.logging.Logger;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class LoginRequestBody {
    private static final Logger logger = Logger.getLogger(LoginRequestBody.class.getName());
    private int employeeId;
    private String employeePassword;

    public int getEmployeeId() {
        logger.info("LoginRequestBody object created");
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }
}
