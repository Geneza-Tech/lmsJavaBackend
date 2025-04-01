package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.Batch;
import com.geneza.lms.persistence.BatchRepository;
import com.geneza.lms.service.BatchService;
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


@Controller("BatchRestController")
public class BatchRestController {

    @Autowired
    private BatchRepository batchRepository;

    @Autowired
    private BatchService batchService;

    @RequestMapping(value = "/Batch", method = RequestMethod.PUT)
    @ResponseBody
    public Batch saveBatch(@RequestBody Batch batch) {
    batchService.saveBatch(batch);
        return batchRepository.findById(batch.getId());
    }

    @RequestMapping(value = "/Batch", method = RequestMethod.POST)
    @ResponseBody
    public Batch newBatch(@RequestBody Batch batch) {
    batchService.saveBatch(batch);
        return batchRepository.findById(batch.getId());
    }

    @RequestMapping(value = "/Batch", method = RequestMethod.GET)
    @ResponseBody
    public List<Batch> listBatchs() {
        return new java.util.ArrayList<Batch>(batchService.findAll());
    }

    @RequestMapping(value = "/Batch/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public Batch loadBatch(@PathVariable Integer batch_id) {
        return batchService.findById(batch_id);
    }

    @RequestMapping(value = "/Batch/Delete/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteBatch(@PathVariable Integer batch_id) {
        return batchService.deleteBatch(batch_id);
    }
    @RequestMapping(value = "/Batch/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Batch> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (batchRepository.findAll(pageable));
    }

 @RequestMapping(value = "/Batch/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<Batch> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (batchRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/Batch/Course/{course_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Batch> getAllByCourseId(@PathVariable("course_id") Integer courseId) {
        return new java.util.ArrayList<Batch>(batchService.findAllByCourseId(courseId));
    }

    @RequestMapping(value = "/Batch/Country/{country_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Batch> getAllByCountryId(@PathVariable("country_id") Integer countryId) {
        return new java.util.ArrayList<Batch>(batchService.findAllByCountryId(countryId));
    }

    @RequestMapping(value = "/Batch/BatchStatus/{batchStatus_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<Batch> getAllByBatchStatusId(@PathVariable("batchStatus_id") Integer batchStatusId) {
        return new java.util.ArrayList<Batch>(batchService.findAllByBatchStatusId(batchStatusId));
    }

    @RequestMapping(value = "/Batch/Filter", method = RequestMethod.GET)
    @ResponseBody
    public List<Batch> getAllByFilters(
            @RequestParam(value = "courseId", required = false) Integer courseId,
            @RequestParam(value = "countryId", required = false) Integer countryId,
            @RequestParam(value = "batchStatusId", required = false) Integer batchStatusId) {
        return batchService.getBatchesByFilters(courseId, countryId, batchStatusId);
    }


}