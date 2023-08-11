package org.example.demo.util;

import org.example.demo.dtos.AppUserDetails;
import org.example.demo.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    public AppUserDetails toUserDetails(User user) {
        AppUserDetails desired = new AppUserDetails();
        BeanUtils.copyProperties(user,desired);
        return desired;
    }

}
