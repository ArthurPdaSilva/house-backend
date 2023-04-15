package br.edu.ifpb.dac.arthur.house.business.interfaces;

import br.edu.ifpb.dac.arthur.house.model.entities.SystemRole;

public interface SystemRoleService {

    enum AVAILABLE_ROLES { ADMIN, USER }
    void createDefaultValues();
    SystemRole findByName(String name);
    SystemRole findDefault();

}
