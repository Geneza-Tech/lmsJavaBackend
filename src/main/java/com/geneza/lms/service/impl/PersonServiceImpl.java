package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.PersonRepository;
import com.geneza.lms.domain.Person;
import com.geneza.lms.service.PersonService;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.geneza.lms.domain.enums.ValidationStatus;

@Service("PersonService")
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;
    public PersonServiceImpl() {
    }

    @Transactional
    public Person findById(Integer id) {
        return personRepository.findById(id);
    }

    @Transactional
    public List<Person> findAll() {
        return personRepository.findAll();
    }
     
    @Transactional
    public void savePerson(Person person) {
        Person existingPerson = personRepository.findById(person.getId());
        if (existingPerson != null) {
            if (existingPerson != person) {
                existingPerson.setId(person.getId());
                existingPerson.setFirstName(person.getFirstName());
                existingPerson.setMiddleName(person.getMiddleName()); // new field
                existingPerson.setLastName(person.getLastName());
                existingPerson.setPhone(person.getPhone());
                existingPerson.setEmail(person.getEmail());
                existingPerson.setRollNumber(person.getRollNumber());
                existingPerson.setCountry(person.getCountry());
                existingPerson.setState(person.getState());
                existingPerson.setRegion(person.getRegion());
                existingPerson.setPresentStatus(person.getPresentStatus());
                existingPerson.setvalidationstatus(person.getvalidationstatus());
                existingPerson.setValidationComment(person.getValidationComment()); // new field
                existingPerson.setGender(person.getGender());
                existingPerson.setDob(person.getDob());
                existingPerson.setEnrollmentDate(person.getEnrollmentDate()); // new field
                existingPerson.setaddress(person.getaddress());
                existingPerson.setZone(person.geZone());
                existingPerson.setFatherName(person.getFatherName());
                existingPerson.setMaritalStatus(person.getMaritalStatus());
                existingPerson.setSpouseName(person.getSpouseName());
                existingPerson.setPincode(person.getPincode());
                existingPerson.setDateOfJoining(person.getDateOfJoining()); // new field
                existingPerson.setDateOfLeaving(person.getDateOfLeaving());
                existingPerson.setHighestQualification(person.getHighestQualification()); // new field
                existingPerson.setPhoto(person.getPhoto()); // new field 
                existingPerson.setReasonOfLeaving(person.getReasonOfLeaving());
            }
            person = personRepository.save(existingPerson);
        } else {
            person = personRepository.save(person);
        }
        personRepository.flush();
    }


    public boolean deletePerson(Integer personId) {
        Person person = personRepository.findById(personId);
        if(person!=null) {
            personRepository.delete(person);
            return true;
        }else {
            return false;
        }
    }

    @Transactional
    public List<Person> getPersonsByFilters(String country, String state, String region) {
        return personRepository.findByFilters(country, state, region);
    }

    @Transactional
    public Page<Person> getPersonsByFiltersPagination(Integer countryId, String state, String region, String search, Pageable pageable) {
        return personRepository.findByFilters(countryId, state, region, search, pageable);
    }
    
    @Transactional
    public Page<Person> searchPersons(String search, Pageable pageable) {
        return personRepository.findBySearch(search, pageable);
    }
    
    @Override
    public Person updateValidationStatus(Integer id, ValidationStatus status) {
        Person person = personRepository.findById(id);
        if (person == null) {
            throw new RuntimeException("Person not found with id: " + id);
        }
        person.setvalidationstatus(status);
        return personRepository.save(person);
    }

    @Override
public Person updatePhoto(Integer id, String photoUrl) {
    Person person = personRepository.findById(id);
    if (person == null) {
        throw new RuntimeException("Person not found with id: " + id);
    }
    person.setPhoto(photoUrl);  // Set the photo URL
    return personRepository.save(person);  // Save changes
}

}