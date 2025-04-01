package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.CountryRepository;
import com.geneza.lms.domain.Country;
import com.geneza.lms.service.CountryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("CountryService")
@Transactional
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;
    public CountryServiceImpl() {
    }

    @Transactional
    public Country findById(Integer id) {
        return countryRepository.findById(id);
    }

    @Transactional
    public List<Country> findAll() {
        return countryRepository.findAll();
    }
     
    @Transactional
    public void saveCountry(Country country) {
        Country existingCountry = countryRepository.findById(country.getId());
        if (existingCountry != null) {
        if (existingCountry != country) {      
        existingCountry.setId(country.getId());
                existingCountry.setCountry(country.getCountry());
        }
        country = countryRepository.save(existingCountry);
    }else{
        country = countryRepository.save(country);
        }
        countryRepository.flush();
    }

    public boolean deleteCountry(Integer countryId) {
        Country country = countryRepository.findById(countryId);
        if(country!=null) {
            countryRepository.delete(country);
            return true;
        }else {
            return false;
        }
    }

    

}