package com.dao;

import com.model.Users;
import com.model.Transfer;

import java.util.List;


public interface OperationsDAO {

    List<Users> getAllUsers();

    List<Users> getUser(String fullName);



    int updateTransaction(String from, String to, long credit);

    int updateFromUser(String from, long credit);

    int updateToUser(String to, long credit);
}
