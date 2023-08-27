package org.example.registry.util;

import org.example.registry.dtos.AppUserDetails;
import org.example.registry.entities.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserUtil {

    public AppUserDetails toUserDetails(UserEntity user) {
        AppUserDetails desired = new AppUserDetails();
        BeanUtils.copyProperties(user,desired);
        return desired;
    }

}
