package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Trainer;
import com.geneza.lms.persistence.TrainerRepository;
import com.geneza.lms.service.TrainerService;
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


@Controller("TrainerRestController")
public class TrainerRestController {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private TrainerService trainerService;

    @RequestMapping(value = "/Trainer", method = RequestMethod.PUT)
    @ResponseBody
    public Trainer saveTrainer(@RequestBody Trainer trainer) {
    trainerService.saveTrainer(trainer);
        return trainerRepository.findById(trainer.getId());
    }

    @RequestMapping(value = "/Trainer", method = RequestMethod.POST)
    @ResponseBody
    public Trainer newTrainer(@RequestBody Trainer trainer) {
    trainerService.saveTrainer(trainer);
        return trainerRepository.findById(trainer.getId());
    }

    @RequestMapping(value = "/Trainer", method = RequestMethod.GET)
    @ResponseBody
    public List<Trainer> listTrainers() {
        return new java.util.ArrayList<Trainer>(trainerService.findAll());
    }

    @RequestMapping(value = "/Trainer/{trainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public Trainer loadTrainer(@PathVariable Integer trainer_id) {
        return trainerService.findById(trainer_id);
    }

    @RequestMapping(value = "/Trainer/Delete/{trainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteTrainer(@PathVariable Integer trainer_id) {
        return trainerService.deleteTrainer(trainer_id);
    }

 @RequestMapping(value = "/Trainer/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Trainer> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (trainerRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/Trainer/Trainer/{trainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Trainer> getAllByTrainerId(@PathVariable("trainer_id") Integer trainerId) {
        return new java.util.ArrayList<Trainer>(trainerService.findAllByTrainerId(trainerId));
    }

}