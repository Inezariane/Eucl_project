package com.eucl.repository;

import java.util.List;
import com.eucl.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Token findByToken(String token);
    Token findByMeterNumber(String meterNumber);
    List<Token> findByTokenStatus(TokenStatus tokenStatus);
}
