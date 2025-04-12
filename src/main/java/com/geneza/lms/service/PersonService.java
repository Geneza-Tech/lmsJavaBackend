package com.geneza.lms.service;
import com.geneza.lms.domain.Person;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonService {
    public Person findById(Integer id);
    public void savePerson(Person person_1);
    public boolean deletePerson(Integer personId);
    public List<Person> findAll();
    List<Person> getPersonsByFilters(String country, String state, String region);
    Page<Person> getPersonsByFiltersPagination(Integer countryId, String state, String region,String search,  Pageable pageable);
    Page<Person> searchPersons(String search, Pageable pageable);

}