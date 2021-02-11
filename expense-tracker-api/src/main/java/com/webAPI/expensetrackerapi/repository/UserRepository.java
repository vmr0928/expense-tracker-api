package com.webAPI.expensetrackerapi.repository;

import com.webAPI.expensetrackerapi.domain.User;
import com.webAPI.expensetrackerapi.exceptions.ETAuthException;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws ETAuthException;

    Integer getCountByEmail(String Email);

    User findByEmailAndPassword(String email, String password) throws ETAuthException;

    User findById(Integer userId);
}
