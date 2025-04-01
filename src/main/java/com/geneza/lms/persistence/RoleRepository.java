package  com.geneza.lms.persistence;  
import  com.geneza.lms.domain.Role;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {	 
    Role findById(Integer id);
    List<Role> findAll();
}