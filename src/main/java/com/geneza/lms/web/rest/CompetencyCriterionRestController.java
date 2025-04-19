package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.CompetencyCriterion;
import com.geneza.lms.persistence.CompetencyCriterionRepository;
import com.geneza.lms.service.CompetencyCriterionService;
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


@Controller("CompetencyCriterionRestController")
public class CompetencyCriterionRestController {

    @Autowired
    private CompetencyCriterionRepository competencyCriterionRepository;

    @Autowired
    private CompetencyCriterionService competencyCriterionService;

    @RequestMapping(value = "/CompetencyCriterion", method = RequestMethod.PUT)
    @ResponseBody
    public CompetencyCriterion saveCompetencyCriterion(@RequestBody CompetencyCriterion competencyCriterion) {
    competencyCriterionService.saveCompetencyCriterion(competencyCriterion);
        return competencyCriterionRepository.findById(competencyCriterion.getId());
    }

    @RequestMapping(value = "/CompetencyCriterion", method = RequestMethod.POST)
    @ResponseBody
    public CompetencyCriterion newCompetencyCriterion(@RequestBody CompetencyCriterion competencyCriterion) {
    competencyCriterionService.saveCompetencyCriterion(competencyCriterion);
        return competencyCriterionRepository.findById(competencyCriterion.getId());
    }

    @RequestMapping(value = "/CompetencyCriterion", method = RequestMethod.GET)
    @ResponseBody
    public List<CompetencyCriterion> listCompetencyCriterions() {
        return new java.util.ArrayList<CompetencyCriterion>(competencyCriterionService.findAll());
    }

    @RequestMapping(value = "/CompetencyCriterion/{competencyCriterion_id}", method = RequestMethod.GET)
    @ResponseBody
    public CompetencyCriterion loadCompetencyCriterion(@PathVariable Integer competencyCriterion_id) {
        return competencyCriterionService.findById(competencyCriterion_id);
    }

    @RequestMapping(value = "/CompetencyCriterion/Delete/{competencyCriterion_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteCompetencyCriterion(@PathVariable Integer competencyCriterion_id) {
        return competencyCriterionService.deleteCompetencyCriterion(competencyCriterion_id);
    }

 @RequestMapping(value = "/CompetencyCriterion/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<CompetencyCriterion> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (competencyCriterionRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/CompetencyCriterion/CompetencyCategory/{competencyCategory_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<CompetencyCriterion> getAllByCompetencyCategoryId(@PathVariable("competencyCategory_id") Integer competencyCategoryId) {
        return new java.util.ArrayList<CompetencyCriterion>(competencyCriterionService.findAllByCompetencyCategoryId(competencyCategoryId));
    }

}