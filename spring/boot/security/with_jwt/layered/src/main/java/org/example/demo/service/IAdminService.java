package org.example.demo.service;

import org.example.demo.dtos.AddAdmin;
import org.example.demo.dtos.AdminDetails;

public interface IAdminService {
    AdminDetails register(AddAdmin requestData);
}
