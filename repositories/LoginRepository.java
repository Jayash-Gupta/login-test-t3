package com.picafe.team_3.repositories;

import com.picafe.team_3.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByEmployeeId(int employeeId);
}
