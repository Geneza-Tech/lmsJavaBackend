package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.BatchStatus;
import com.geneza.lms.persistence.BatchStatusRepository;
import com.geneza.lms.service.BatchStatusService;
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


@Controller("BatchStatusRestController")
public class BatchStatusRestController {

    @Autowired
    private BatchStatusRepository batchStatusRepository;

    @Autowired
    private BatchStatusService batchStatusService;

    @RequestMapping(value = "/BatchStatus", method = RequestMethod.PUT)
    @ResponseBody
    public BatchStatus saveBatchStatus(@RequestBody BatchStatus batchStatus) {
    batchStatusService.saveBatchStatus(batchStatus);
        return batchStatusRepository.findById(batchStatus.getId());
    }

    @RequestMapping(value = "/BatchStatus", method = RequestMethod.POST)
    @ResponseBody
    public BatchStatus newBatchStatus(@RequestBody BatchStatus batchStatus) {
    batchStatusService.saveBatchStatus(batchStatus);
        return batchStatusRepository.findById(batchStatus.getId());
    }

    @RequestMapping(value = "/BatchStatus", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchStatus> listBatchStatuss() {
        return new java.util.ArrayList<BatchStatus>(batchStatusService.findAll());
    }

    @RequestMapping(value = "/BatchStatus/{batchStatus_id}", method = RequestMethod.GET)
    @ResponseBody
    public BatchStatus loadBatchStatus(@PathVariable Integer batchStatus_id) {
        return batchStatusService.findById(batchStatus_id);
    }

    @RequestMapping(value = "/BatchStatus/Delete/{batchStatus_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteBatchStatus(@PathVariable Integer batchStatus_id) {
        return batchStatusService.deleteBatchStatus(batchStatus_id);
    }
    @RequestMapping(value = "/BatchStatus/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<BatchStatus> findAllPaged(@PathVariable Integer page){
    	Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
		Pageable pageable = new PageRequest(page, 5, sort);
    	return (batchStatusRepository.findAll(pageable));
    }

 @RequestMapping(value = "/BatchStatus/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<BatchStatus> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (batchStatusRepository.findAll(sortedPaged));
    }


}