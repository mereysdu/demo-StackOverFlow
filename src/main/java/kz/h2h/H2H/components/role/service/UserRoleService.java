package kz.h2h.H2H.components.role.service;

import kz.h2h.H2H.components.role.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;

}
