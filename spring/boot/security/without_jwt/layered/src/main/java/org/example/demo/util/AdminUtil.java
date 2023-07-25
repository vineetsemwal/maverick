package org.example.demo.util;

import org.example.demo.dtos.AdminDetails;
import org.example.demo.entities.Admin;
import org.example.demo.entities.User;
import org.springframework.stereotype.Component;

@Component
public class AdminUtil {


    public AdminDetails adminDetails(Admin admin) {
        User user = admin.getUser();
        AdminDetails desired = new AdminDetails();
        desired.setAdminId(admin.getId());
        desired.setRoles(user.getRoles());
        desired.setUsername(user.getUsername());
        return desired;
    }

}
