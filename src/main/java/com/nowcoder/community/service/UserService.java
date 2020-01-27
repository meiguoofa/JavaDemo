package com.nowcoder.community.service;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findUserById(int userId){
        return userMapper.selectById(userId);
    }

    public User findUserByName(String username){
        return userMapper.selectByName(username);
    }

    public User findUserByEmail(String email){
        return userMapper.selectByEmail(email);
    }



}
