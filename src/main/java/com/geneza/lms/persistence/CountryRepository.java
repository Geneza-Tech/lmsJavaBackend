package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Country;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {	 
    Country findById(Integer id);
    List<Country> findAll();  
   Page<Country> findAll(Pageable pageable);

}