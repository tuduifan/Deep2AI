package com.wang.sevice;

import com.wang.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp{
    @Autowired
    UserDao userDao;
}
