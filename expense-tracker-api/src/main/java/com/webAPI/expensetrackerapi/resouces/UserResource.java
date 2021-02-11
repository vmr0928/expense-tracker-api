package com.webAPI.expensetrackerapi.resouces;

import com.webAPI.expensetrackerapi.Constants;
import com.webAPI.expensetrackerapi.domain.User;
import com.webAPI.expensetrackerapi.services.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, Object> UserMap){

        String firstName = (String) UserMap.get("firstName");
        String lastName = (String) UserMap.get("lastName");
        String email = (String) UserMap.get("email");
        String password = (String) UserMap.get("password");
        User user = userService.registerUser(firstName, lastName, email, password);

        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, Object> LoginMap){

        String email = (String) LoginMap.get("email");
        String password = (String) LoginMap.get("password");

        User user = userService.validateUser(email, password);

        return new ResponseEntity<>(generateJWTToken(user), HttpStatus.OK);
    }

    private Map<String, String> generateJWTToken(User user){

        long issuedTime = System.currentTimeMillis();

        String jwtToken = Jwts.builder().signWith(SignatureAlgorithm.HS256, Constants.API_SECRET_KEY)
                                        .setIssuedAt(new Date(issuedTime))
                                        .setExpiration(new Date(issuedTime + Constants.EXPIRATION))
                                        .claim("UserId", user.getUserId())
                                        .claim("firstName", user.getFirstName())
                                        .claim("lastName", user.getLastName())
                                        .compact();
        Map<String, String> map = new HashMap<>();
        map.put("JWTToken", jwtToken);
        return map;
    }
}
