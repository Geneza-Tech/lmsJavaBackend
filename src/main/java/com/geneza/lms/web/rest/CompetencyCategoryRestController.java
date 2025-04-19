package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.CompetencyCategory;
import com.geneza.lms.persistence.CompetencyCategoryRepository;
import com.geneza.lms.service.CompetencyCategoryService;
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


@Controller("CompetencyCategoryRestController")
public class CompetencyCategoryRestController {

    @Autowired
    private CompetencyCategoryRepository competencyCategoryRepository;

    @Autowired
    private CompetencyCategoryService competencyCategoryService;

    @RequestMapping(value = "/CompetencyCategory", method = RequestMethod.PUT)
    @ResponseBody
    public CompetencyCategory saveCompetencyCategory(@RequestBody CompetencyCategory competencyCategory) {
    competencyCategoryService.saveCompetencyCategory(competencyCategory);
        return competencyCategoryRepository.findById(competencyCategory.getId());
    }

    @RequestMapping(value = "/CompetencyCategory", method = RequestMethod.POST)
    @ResponseBody
    public CompetencyCategory newCompetencyCategory(@RequestBody CompetencyCategory competencyCategory) {
    competencyCategoryService.saveCompetencyCategory(competencyCategory);
        return competencyCategoryRepository.findById(competencyCategory.getId());
    }

    @RequestMapping(value = "/CompetencyCategory", method = RequestMethod.GET)
    @ResponseBody
    public List<CompetencyCategory> listCompetencyCategorys() {
        return new java.util.ArrayList<CompetencyCategory>(competencyCategoryService.findAll());
    }

    @RequestMapping(value = "/CompetencyCategory/{competencyCategory_id}", method = RequestMethod.GET)
    @ResponseBody
    public CompetencyCategory loadCompetencyCategory(@PathVariable Integer competencyCategory_id) {
        return competencyCategoryService.findById(competencyCategory_id);
    }

    @RequestMapping(value = "/CompetencyCategory/Delete/{competencyCategory_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteCompetencyCategory(@PathVariable Integer competencyCategory_id) {
        return competencyCategoryService.deleteCompetencyCategory(competencyCategory_id);
    }

 @RequestMapping(value = "/CompetencyCategory/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<CompetencyCategory> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (competencyCategoryRepository.findAll(sortedPaged));
    }


}