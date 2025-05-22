package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.BatchTrainer;
import com.geneza.lms.persistence.BatchTrainerRepository;
import com.geneza.lms.service.BatchTrainerService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
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


@Controller("BatchTrainerRestController")
public class BatchTrainerRestController {

    @Autowired
    private BatchTrainerRepository batchTrainerRepository;

    @Autowired
    private BatchTrainerService batchTrainerService;

    @RequestMapping(value = "/BatchTrainer", method = RequestMethod.PUT)
    @ResponseBody
    public BatchTrainer saveBatchTrainer(@RequestBody BatchTrainer batchTrainer) {
    batchTrainerService.saveBatchTrainer(batchTrainer);
        return batchTrainerRepository.findById(batchTrainer.getId());
    }

    @RequestMapping(value = "/BatchTrainer", method = RequestMethod.POST)
    @ResponseBody
    public BatchTrainer newBatchTrainer(@RequestBody BatchTrainer batchTrainer) {
    batchTrainerService.saveBatchTrainer(batchTrainer);
        return batchTrainerRepository.findById(batchTrainer.getId());
    }

    @RequestMapping(value = "/BatchTrainer", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchTrainer> listBatchTrainers() {
        return new java.util.ArrayList<BatchTrainer>(batchTrainerService.findAll());
    }

    @RequestMapping(value = "/BatchTrainer/{batchTrainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public BatchTrainer loadBatchTrainer(@PathVariable Integer batchTrainer_id) {
        return batchTrainerService.findById(batchTrainer_id);
    }

    @RequestMapping(value = "/BatchTrainer/Delete/{batchTrainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteBatchTrainer(@PathVariable Integer batchTrainer_id) {
        return batchTrainerService.deleteBatchTrainer(batchTrainer_id);
    }

 @RequestMapping(value = "/BatchTrainer/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<BatchTrainer> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (batchTrainerRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/BatchTrainer/Batch/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchTrainer> getAllByBatchId(@PathVariable("batch_id") Integer batchId) {
        return new java.util.ArrayList<BatchTrainer>(batchTrainerService.findAllByBatchId(batchId));
    }

    @RequestMapping(value = "/BatchTrainer/Trainer/{trainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchTrainer> getAllByTrainerId(@PathVariable("trainer_id") Integer trainerId) {
        return new java.util.ArrayList<BatchTrainer>(batchTrainerService.findAllByTrainerId(trainerId));
    }


    @RequestMapping(value = "/BatchTrainer//by-person/{personId}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchTrainer> getBatchTrainersByPersonId(@PathVariable Integer personId) {
        return batchTrainerService.findByPersonId(personId);
    }

}