package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Person;
import com.geneza.lms.domain.enums.ValidationStatus;
import com.geneza.lms.persistence.PersonRepository;
import com.geneza.lms.service.FileStorageService;
import com.geneza.lms.service.PersonService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

@Controller("PersonRestController")
public class PersonRestController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private FileStorageService fileStorageService;

    @RequestMapping(value = "/Person", method = RequestMethod.PUT)
    @ResponseBody
    public Person savePerson(@RequestBody Person person) {
    personService.savePerson(person);
        return personRepository.findById(person.getId());
    }

    @RequestMapping(value = "/Person", method = RequestMethod.POST, consumes = {"multipart/form-data"})
@ResponseBody
public Person newPerson(
        @RequestPart("personData") String personDataJson,
        @RequestPart(value = "file", required = false) MultipartFile file) {

    try {
        // Parse the JSON string to create a Person object
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(personDataJson, Person.class);

        // Upload photo if present
        if (file != null && !file.isEmpty()) {
            String photoUrl = fileStorageService.uploadFile(file);
            person.setPhoto(photoUrl);
        }

        // Save person
        personService.savePerson(person);

        return personRepository.findById(person.getId());
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Creating person failed: " + e.getMessage());
    }
}


    @RequestMapping(value = "/Person/uploadPhoto", method = RequestMethod.POST, consumes = {"multipart/form-data"})
@ResponseBody
public Person uploadPersonPhoto(
        @RequestPart("personData") String personDataJson,
        @RequestPart("file") MultipartFile file) {

    try {
        // Parse the JSON string to get person ID
        ObjectMapper mapper = new ObjectMapper();
        JsonNode personData = mapper.readTree(personDataJson);
        
        // Check if personId exists in the JSON
        if (!personData.has("personId") || personData.get("personId").isNull()) {
            throw new RuntimeException("personId is required in personData JSON");
        }
        
        Integer personId = personData.get("personId").asInt();

        // Find the person
        Person person = personService.findById(personId);
        if (person == null) {
            throw new RuntimeException("Person not found with ID: " + personId);
        }

        // Upload the file
        String photoUrl = fileStorageService.uploadFile(file);
        person.setPhoto(photoUrl);
        personService.savePerson(person);

        return personRepository.findById(personId);

    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Photo upload failed: " + e.getMessage());
    }
}


    @RequestMapping(value = "/Person", method = RequestMethod.GET)
    @ResponseBody
    public List<Person> listPersons() {
        return new java.util.ArrayList<Person>(personService.findAll());
    }

    @RequestMapping(value = "/Person/{person_id}", method = RequestMethod.GET)
    @ResponseBody
    public Person loadPerson(@PathVariable Integer person_id) {
        return personService.findById(person_id);
    }

    @RequestMapping(value = "/Person/Delete/{person_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deletePerson(@PathVariable Integer person_id) {
        return personService.deletePerson(person_id);
    }
    @RequestMapping(value = "/Person/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Person> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (personRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Person/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Person> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (personRepository.findAll(sortedPaged));
    }
@RequestMapping(value = "Person/Filter", method =RequestMethod.GET)
    @ResponseBody
    public List<Person> getFilteredPersons(@RequestParam(required = false) String country,
                                           @RequestParam(required = false) String state,
                                           @RequestParam(required = false) String region) {
        return personService.getPersonsByFilters(country, state, region);
    }

    @RequestMapping(value = "Person/Filter/Page", method = RequestMethod.GET)
    @ResponseBody
    public Page<Person> getFilteredPersonsPaged(
            @RequestParam(required = false) Integer countryId,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String region,
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
    
        Pageable pageable = PageRequest.of(page, size);
        return personService.getPersonsByFiltersPagination(countryId, state, region, search, pageable);
    }

    @RequestMapping(value = "Person/Search", method = RequestMethod.GET)
@ResponseBody
public Page<Person> searchPersons(
        @RequestParam(required = false) String search,
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size) {

    Pageable pageable = PageRequest.of(page, size);
    return personService.searchPersons(search, pageable);
}

@RequestMapping(value = "Person/{id}/validation-status", method = RequestMethod.PUT)
@ResponseBody
    public Person updateValidationStatus(@PathVariable Integer id,
                                         @RequestParam ValidationStatus status) {
        return personService.updateValidationStatus(id, status);
    }

    
    
    

}