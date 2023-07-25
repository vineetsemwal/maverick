package org.example.demo.service;

import org.example.demo.dao.IAdminRepository;
import org.example.demo.dtos.AddAdmin;
import org.example.demo.dtos.AdminDetails;
import org.example.demo.entities.Admin;
import org.example.demo.entities.User;
import org.example.demo.util.AdminUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;


@Service
public class AdminServiceImpl implements IAdminService {

    private IAdminRepository repository;
    private AdminUtil adminUtil;

    public AdminServiceImpl(IAdminRepository repository, AdminUtil adminUtil){
        this.repository=repository;
        this.adminUtil=adminUtil;
    }


    @Transactional
    @Override
    public AdminDetails register(AddAdmin requestData) {
        User user=new User();
        user.setUsername(requestData.getUsername());
        user.setPassword(requestData.getPassword());
        Set<String> roles=new HashSet<>();
        roles.add("ADMIN");
        user.setRoles(roles);
        Admin admin = new Admin();
        admin.setUser(user);
        admin=repository.save(admin);
       return adminUtil.adminDetails(admin);
    }
}
