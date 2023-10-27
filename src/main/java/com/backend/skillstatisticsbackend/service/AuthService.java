package com.backend.skillstatisticsbackend.service;

import com.backend.skillstatisticsbackend.model.AuthToken;

public interface AuthService {

    AuthToken validateToken(String token);


}
