package br.edu.ifpb.dac.arthur.house.business.services;

import br.edu.ifpb.dac.arthur.house.business.interfaces.SystemRoleService;
import br.edu.ifpb.dac.arthur.house.model.entities.SystemRole;
import br.edu.ifpb.dac.arthur.house.model.repositories.SystemRoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemRoleServiceImpl implements SystemRoleService {

    private final SystemRoleRepository systemRoleRepository;


    public SystemRoleServiceImpl(SystemRoleRepository systemRoleRepository) {
        this.systemRoleRepository = systemRoleRepository;
    }

    @Override
    public void createDefaultValues() {
        for(AVAILABLE_ROLES availableRoles: AVAILABLE_ROLES.values()) {
            SystemRole role = findByName(availableRoles.name());

            if(role == null) {
                role = new SystemRole();
                role.setName(availableRoles.name());
                systemRoleRepository.save(role);
            }

        }
    }

    @Override
    public SystemRole findByName(String name) {
        Optional<SystemRole> optionalSystemRole = systemRoleRepository.findByName(name);
        return optionalSystemRole.orElse(null);
    }


    @Override
    public SystemRole findDefault() {
        return findByName(AVAILABLE_ROLES.USER.name());
    }
}
