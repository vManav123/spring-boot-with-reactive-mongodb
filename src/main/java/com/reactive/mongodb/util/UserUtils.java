package com.reactive.mongodb.util;

import com.reactive.mongodb.dto.UserRequest;
import com.reactive.mongodb.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

public class UserUtils {

    public static User objectToUser(UserRequest userRequest){
        User user = new User();
        BeanUtils.copyProperties(userRequest,user);
        return user;
    }

    public static UserRequest userToObject(User user){
        UserRequest userRequest = new UserRequest();
        BeanUtils.copyProperties(user,userRequest);
        return userRequest;
    }

}
