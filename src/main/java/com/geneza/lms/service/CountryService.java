package com.geneza.lms.service;
import com.geneza.lms.domain.Country;
import java.util.List;

public interface CountryService {
    public Country findById(Integer id);
    public void saveCountry(Country country_1);
    public boolean deleteCountry(Integer countryId);
    public List<Country> findAll();
}