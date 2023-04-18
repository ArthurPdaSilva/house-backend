package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.business.interfaces.PasswordEncoderService;
import br.edu.ifpb.dac.arthur.house.business.interfaces.SystemRoleService;
import br.edu.ifpb.dac.arthur.house.business.interfaces.SystemUserService;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemRole;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemUser;
import br.edu.ifpb.dac.arthur.house.model.repositories.SystemUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SystemUserServiceImpl implements SystemUserService {

    private final SystemUserRepository systemUserRepository;

    private final SystemRoleService systemRoleService;

    private final PasswordEncoderService passwordEncoderService;

    public SystemUserServiceImpl(SystemUserRepository systemUserRepository, SystemRoleService systemRoleService, PasswordEncoderService passwordEncoderService) {
        this.systemUserRepository = systemUserRepository;
        this.systemRoleService = systemRoleService;
        this.passwordEncoderService = passwordEncoderService;
    }

    @Override
    public SystemUser save(SystemUser systemUser) {
        if(findById(systemUser.getId()) != null) {
            passwordEncoderService.encrypt(systemUser);
            List<SystemRole> roles = new ArrayList<>();
            roles.add(systemRoleService.findDefault());
            systemUser.setRoles(roles);
            return this.systemUserRepository.save(systemUser);
        }

        throw  new IllegalStateException("User is already in the database");
    }

    @Override
    public SystemUser update(SystemUser systemUser) {
        return this.systemUserRepository.save(systemUser);
    }

    @Override
    public void delete(UUID id) {
        this.systemUserRepository.deleteById(id);
    }

    @Override
    public SystemUser findById(UUID id) {
        Optional<SystemUser> systemUser = this.systemUserRepository.findById(id);
        return systemUser.orElse(null);
    }

    @Override
    public SystemUser findByEmail(String email) {
        Optional<SystemUser> systemUser = this.systemUserRepository.findByEmail(email);
        return systemUser.orElse(null);
    }

    @Override
    public SystemUser findByUsername(String username) {
        Optional<SystemUser> systemUser = this.systemUserRepository.findByUsername(username);
        return systemUser.orElse(null);
    }

    @Override
    public List<SystemUser> findAll() {
        return this.systemUserRepository.findAll();
    }

    @Override
    public List<SystemUser> find(SystemUser filter) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser systemUser = findByUsername(username);

        if (systemUser != null) return systemUser;

        throw new UsernameNotFoundException("Could not find any user with username");

    }
}
