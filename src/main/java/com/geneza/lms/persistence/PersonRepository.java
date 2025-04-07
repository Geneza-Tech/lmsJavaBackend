package com.geneza.lms.persistence;  
import com.geneza.lms.domain.Person;
import java.util.List;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {	 
    Person findById(Integer id);
    List<Person> findAll();  
   Page<Person> findAll(Pageable pageable);
       @Query("SELECT p FROM Person p WHERE " +
           "(:country IS NULL OR p.country = :country) AND " +
           "(:state IS NULL OR p.state = :state) AND " +
           "(:region IS NULL OR p.region = :region)")
    List<Person> findByFilters(@Param("country") String country, 
                               @Param("state") String state, 
                               @Param("region") String region);


                               @Query("SELECT p FROM Person p WHERE " +
                               "(:country IS NULL OR p.country = :country) AND " +
                               "(:state IS NULL OR p.state = :state) AND " +
                               "(:region IS NULL OR p.region = :region) AND " +
                               "(:search IS NULL OR " +
                                                   "LOWER(p.firstName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.lastName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.email) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.country) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.state) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.region) LIKE LOWER(CONCAT('%', :search, '%')))")
                        Page<Person> findByFilters(@Param("country") String country,
                                                   @Param("state") String state,
                                                   @Param("region") String region,
                                                   @Param("search") String search,
                                                   Pageable pageable);

        @Query("SELECT p FROM Person p WHERE " +
                                                   "(:search IS NULL OR " +
                                                   "LOWER(p.firstName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.lastName) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.email) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.country) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.state) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
                                                   "LOWER(p.region) LIKE LOWER(CONCAT('%', :search, '%')))")
                        Page<Person> findBySearch(@Param("search") String search, Pageable pageable);
                                            
                        
                        
}