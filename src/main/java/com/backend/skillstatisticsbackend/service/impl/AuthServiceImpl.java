package com.backend.skillstatisticsbackend.service.impl;

import com.backend.skillstatisticsbackend.model.AuthToken;
import com.backend.skillstatisticsbackend.service.AuthService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AuthServiceImpl implements AuthService {

        @Override
        public AuthToken validateToken(String token) {
            RestTemplate restTemplate = new RestTemplate();
            String endpointUrl = "http://localhost:3002/auth/verify";
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            try {
                ResponseEntity<AuthToken> responseEntity = restTemplate.exchange(
                        endpointUrl,
                        HttpMethod.GET,
                        entity,
                        AuthToken.class
                );

                if (!responseEntity.getStatusCode().is2xxSuccessful()) {
                    return null;
                }

                return responseEntity.getBody();
            } catch (Exception e) {

                e.printStackTrace();
                return null;
            }
        }
}
