package  com.geneza.lms.service;
import  com.geneza.lms.domain.Role;
import java.util.List;

public interface RoleService {
    public Role findById(Integer id);
    public void saveRole(Role role);
    public List<Role> findAll();
  //  public List<User> findAllByPersonId(Integer  person);
}