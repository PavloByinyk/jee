package com.example.polls.service;

import com.example.polls.exception.AppException;
import com.example.polls.model.Role;
import com.example.polls.model.RoleName;
import com.example.polls.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public Role findByName(RoleName roleName){
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new AppException("User Role not set."));
    }
}
