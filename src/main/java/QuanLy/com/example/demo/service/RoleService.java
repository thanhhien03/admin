package QuanLy.com.example.demo.service;

import QuanLy.com.example.demo.entity.Role;
import QuanLy.com.example.demo.repository.RoleRepository;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) throws ChangeSetPersister.NotFoundException {
        return roleRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

    public boolean deleteRole(Long id) {
        return deleteRole(id);
    }

    public Role updateRole(Long id, Role role) {
        return updateRole(id, role);
    }

    public Role createRole(Role role) {
        return createRole(role);
    }
}
