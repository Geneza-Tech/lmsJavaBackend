package com.geneza.lms.web.rest; 
import com.geneza.lms.domain.BatchModule;
import com.geneza.lms.persistence.BatchModuleRepository;
import com.geneza.lms.service.BatchModuleService;
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


@Controller("BatchModuleRestController")
public class BatchModuleRestController {

    @Autowired
    private BatchModuleRepository batchModuleRepository;

    @Autowired
    private BatchModuleService batchModuleService;

    @RequestMapping(value = "/BatchModule", method = RequestMethod.PUT)
    @ResponseBody
    public BatchModule saveBatchModule(@RequestBody BatchModule batchModule) {
    batchModuleService.saveBatchModule(batchModule);
        return batchModuleRepository.findById(batchModule.getId());
    }

    @RequestMapping(value = "/BatchModule", method = RequestMethod.POST)
    @ResponseBody
    public BatchModule newBatchModule(@RequestBody BatchModule batchModule) {
    batchModuleService.saveBatchModule(batchModule);
        return batchModuleRepository.findById(batchModule.getId());
    }

    @RequestMapping(value = "/BatchModule", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchModule> listBatchModules() {
        return new java.util.ArrayList<BatchModule>(batchModuleService.findAll());
    }

    @RequestMapping(value = "/BatchModule/{batchModule_id}", method = RequestMethod.GET)
    @ResponseBody
    public BatchModule loadBatchModule(@PathVariable Integer batchModule_id) {
        return batchModuleService.findById(batchModule_id);
    }

    @RequestMapping(value = "/BatchModule/Delete/{batchModule_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteBatchModule(@PathVariable Integer batchModule_id) {
        return batchModuleService.deleteBatchModule(batchModule_id);
    }

 @RequestMapping(value = "/BatchModule/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<BatchModule> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction){
				
		Sort sort;
		
		if(direction ==1)
			sort = Sort.by(sortField).descending();
		else
			sort = Sort.by(sortField).ascending();
		
		Pageable sortedPaged = PageRequest.of(page, 10, sort);
    	return (batchModuleRepository.findAll(sortedPaged));
    }


    @RequestMapping(value = "/BatchModule/Batch/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchModule> getAllByBatchId(@PathVariable("batch_id") Integer batchId) {
        return new java.util.ArrayList<BatchModule>(batchModuleService.findAllByBatchId(batchId));
    }

    @RequestMapping(value = "/BatchModule/Module/{module_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchModule> getAllByModuleId(@PathVariable("module_id") Integer moduleId) {
        return new java.util.ArrayList<BatchModule>(batchModuleService.findAllByModuleId(moduleId));
    }

}