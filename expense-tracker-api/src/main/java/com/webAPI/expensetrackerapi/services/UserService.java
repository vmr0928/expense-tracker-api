package com.webAPI.expensetrackerapi.services;

import com.webAPI.expensetrackerapi.domain.User;
import com.webAPI.expensetrackerapi.exceptions.ETAuthException;

public interface UserService {

    User validateUser(String email, String password) throws ETAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws ETAuthException;
}
