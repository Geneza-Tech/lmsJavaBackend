package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Country;
import com.geneza.lms.persistence.CountryRepository;
import com.geneza.lms.service.CountryService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;


@Controller("CountryRestController")
public class CountryRestController {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/Country", method = RequestMethod.PUT)
    @ResponseBody
    public Country saveCountry(@RequestBody Country country) {
    countryService.saveCountry(country);
        return countryRepository.findById(country.getId());
    }

    @RequestMapping(value = "/Country", method = RequestMethod.POST)
    @ResponseBody
    public Country newCountry(@RequestBody Country country) {
    countryService.saveCountry(country);
        return countryRepository.findById(country.getId());
    }

    @RequestMapping(value = "/Country", method = RequestMethod.GET)
    @ResponseBody
    public List<Country> listCountrys() {
        return new java.util.ArrayList<Country>(countryService.findAll());
    }

    @RequestMapping(value = "/Country/{country_id}", method = RequestMethod.GET)
    @ResponseBody
    public Country loadCountry(@PathVariable Integer country_id) {
        return countryService.findById(country_id);
    }

    @RequestMapping(value = "/Country/Delete/{country_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteCountry(@PathVariable Integer country_id) {
        return countryService.deleteCountry(country_id);
    }
    @RequestMapping(value = "/Country/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Country> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (countryRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Country/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Country> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (countryRepository.findAll(sortedPaged));
    }


}