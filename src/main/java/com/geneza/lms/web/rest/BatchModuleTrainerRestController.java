package com.geneza.lms.web.rest;

import com.geneza.lms.domain.BatchModuleTrainer;
import com.geneza.lms.dto.BatchModuleTrainerUpdateRequest;
import com.geneza.lms.dto.BatchTrainerUpdateRequest;
import com.geneza.lms.persistence.BatchModuleTrainerRepository;
import com.geneza.lms.service.BatchModuleTrainerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Controller("BatchModuleTrainerRestController")
public class BatchModuleTrainerRestController {

    @Autowired
    private BatchModuleTrainerRepository batchModuleTrainerRepository;

    @Autowired
    private BatchModuleTrainerService batchModuleTrainerService;

    @RequestMapping(value = "/web/rest/BatchModuleTrainer", method = RequestMethod.PUT)
    @ResponseBody
    public BatchModuleTrainer saveBatchModuleTrainer(@RequestBody BatchModuleTrainer batchModuleTrainer) {
        batchModuleTrainerService.saveBatchModuleTrainer(batchModuleTrainer);
        return batchModuleTrainerRepository.findById(batchModuleTrainer.getId());
    }

    @RequestMapping(value = "/web/rest/BatchModuleTrainer", method = RequestMethod.POST)
    @ResponseBody
    public BatchModuleTrainer newBatchModuleTrainer(@RequestBody BatchModuleTrainer batchModuleTrainer) {
        batchModuleTrainerService.saveBatchModuleTrainer(batchModuleTrainer);
        return batchModuleTrainerRepository.findById(batchModuleTrainer.getId());
    }

    @RequestMapping(value = "/web/rest/BatchModuleTrainer", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchModuleTrainer> listBatchModuleTrainers() {
        return new java.util.ArrayList<BatchModuleTrainer>(batchModuleTrainerService.findAll());
    }

    @RequestMapping(value = "/web/rest/BatchModuleTrainer/{batchModuleTrainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public BatchModuleTrainer loadBatchModuleTrainer(@PathVariable Integer batchModuleTrainer_id) {
        return batchModuleTrainerService.findById(batchModuleTrainer_id);
    }

    @RequestMapping(value = "/web/rest/BatchModuleTrainer/Delete/{batchModuleTrainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteBatchModuleTrainer(@PathVariable Integer batchModuleTrainer_id) {
        return batchModuleTrainerService.deleteBatchModuleTrainer(batchModuleTrainer_id);
    }

    @RequestMapping(value = "/web/rest/BatchModuleTrainer/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<BatchModuleTrainer> findAllPaged(@PathVariable Integer page) {
        Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
        Pageable pageable = new PageRequest(page, 5, sort);
        return batchModuleTrainerRepository.findAll(pageable);
    }

    @RequestMapping(value = "/web/rest/BatchModuleTrainer/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<BatchModuleTrainer> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction) {
        Sort sort;
        if (direction == 1)
            sort = Sort.by(sortField).descending();
        else
            sort = Sort.by(sortField).ascending();
        Pageable sortedPaged = PageRequest.of(page, 10, sort);
        return batchModuleTrainerRepository.findAll(sortedPaged);
    }

    @RequestMapping(value = "/web/rest/BatchModuleTrainer/BatchModule/{batchModule_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchModuleTrainer> getAllByBatchModuleId(@PathVariable("batchModule_id") Integer batchModuleId) {
        return new java.util.ArrayList<BatchModuleTrainer>(batchModuleTrainerService.findAllByBatchModuleId(batchModuleId));
    }

    @RequestMapping(value = "/web/rest/BatchModuleTrainer/BatchTrainer/{batchTrainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchModuleTrainer> getAllByBatchTrainerId(@PathVariable("batchTrainer_id") Integer batchTrainerId) {
        return new java.util.ArrayList<BatchModuleTrainer>(batchModuleTrainerService.findAllByBatchTrainerId(batchTrainerId));
    }

    @RequestMapping(value = "/web/rest/BatchModuleTrainer/Batch/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<BatchModuleTrainer> getAllByBatchId(@PathVariable("batch_id") Integer batchId) {
        return batchModuleTrainerService.findAllByBatchId(batchId);
    }

    @PostMapping("/BatchModuleTrainer/bulkUpdate")
@ResponseBody
public void updateBatchModuleTrainers(
        @RequestBody BatchModuleTrainerUpdateRequest request) {

    batchModuleTrainerService.updateBatchModuleTrainers(request);
}
}