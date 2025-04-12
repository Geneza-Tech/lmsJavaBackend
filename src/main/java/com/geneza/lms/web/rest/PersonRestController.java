package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Person;
import com.geneza.lms.persistence.PersonRepository;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


@Controller("PersonRestController")
public class PersonRestController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/Person", method = RequestMethod.PUT)
    @ResponseBody
    public Person savePerson(@RequestBody Person person) {
    personService.savePerson(person);
        return personRepository.findById(person.getId());
    }

    @RequestMapping(value = "/Person", method = RequestMethod.POST)
    @ResponseBody
    public Person newPerson(@RequestBody Person person) {
    personService.savePerson(person);
        return personRepository.findById(person.getId());
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

    

}