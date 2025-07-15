package  com.geneza.lms.service;
import  com.geneza.lms.domain.User;
import  com.geneza.lms.domain.Person;
import java.util.List;

public interface UserService {
    public User findById(Integer id);
    public User saveUser(User user_1);
    public List<User> findAll();
    public Person getPerson();
  //  public List<User> findAllByPersonId(Integer  person);
}