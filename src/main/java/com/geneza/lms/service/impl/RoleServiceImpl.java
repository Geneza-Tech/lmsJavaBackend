package  com.geneza.lms.service.impl;
import  com.geneza.lms.persistence.RoleRepository;
import  com.geneza.lms.domain.Role;
import  com.geneza.lms.service.RoleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RoleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;
    
    public RoleServiceImpl() {
    }

    @Transactional
    public Role findById(Integer id) {
        return roleRepository.findById(id);
    }

    @Transactional
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
     
    @Transactional
    public void saveRole(Role role) {
        Role existingRole = roleRepository.findById(role.getId());
        if (existingRole!= null) {
        if (existingRole != role) {    
        existingRole.setId(role.getId());
            existingRole.setName(role.getName());
        }
        role = roleRepository.save(existingRole);
    }else{
        role= roleRepository.save(role);
        }
        roleRepository.flush();
    }
    

}