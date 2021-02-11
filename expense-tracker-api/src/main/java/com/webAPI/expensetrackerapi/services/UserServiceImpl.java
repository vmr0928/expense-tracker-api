package com.webAPI.expensetrackerapi.services;

import com.webAPI.expensetrackerapi.domain.User;
import com.webAPI.expensetrackerapi.exceptions.ETAuthException;
import com.webAPI.expensetrackerapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws ETAuthException {
        if(email != null){
            email = email.toLowerCase();
        }
        if(! email.matches("^(.+)@(.+)$")){
            throw new ETAuthException("Invalid Email Format");
        }
        Integer count = userRepository.getCountByEmail(email);
        if(count > 0){
            throw new ETAuthException("Email already in use");
        }
        Integer userId = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }

    @Override
    public User validateUser(String email, String password) throws ETAuthException {

        if(email != null){
            email = email.toLowerCase();
        }
        return userRepository.findByEmailAndPassword(email, password);
    }
}
