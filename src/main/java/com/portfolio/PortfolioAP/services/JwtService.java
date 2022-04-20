package com.portfolio.PortfolioAP.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import java.util.Date;

@Service
public class JwtService {

    @Autowired
    private Environment env;

    public String create(int user_id) throws JWTCreationException {
        Date expireDate = new Date();
        long exp = (expireDate.getTime() + 210 * 24 * 3600) / 1000;
        Algorithm algorithm = Algorithm.HMAC256(env.getProperty("jwtSecret"));
        String token = JWT.create().withClaim("exp", exp).withClaim("sub", user_id).withIssuer(env.getProperty("jwtIssuer")).sign(algorithm);
        return token;
    }

    public DecodedJWT verify(String token) throws IOException {
        Algorithm algorithm = Algorithm.HMAC256(env.getProperty("jwtSecret"));
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(env.getProperty("jwtIssuer")).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt;

    }

}
