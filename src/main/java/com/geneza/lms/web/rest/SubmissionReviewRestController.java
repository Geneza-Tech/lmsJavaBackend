package com.geneza.lms.web.rest;

import com.geneza.lms.domain.SubmissionReview;
import com.geneza.lms.persistence.SubmissionReviewRepository;
import com.geneza.lms.service.SubmissionReviewService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@Controller("SubmissionReviewRestController")
public class SubmissionReviewRestController {

    @Autowired
    private SubmissionReviewRepository submissionReviewRepository;

    @Autowired
    private SubmissionReviewService submissionReviewService;

    @RequestMapping(value = "/web/rest/SubmissionReview", method = RequestMethod.PUT)
    @ResponseBody
    public SubmissionReview saveSubmissionReview(@RequestBody SubmissionReview submissionReview) {
        submissionReviewService.saveSubmissionReview(submissionReview);
        return submissionReviewRepository.findById(submissionReview.getId());
    }

    @RequestMapping(value = "/web/rest/SubmissionReview", method = RequestMethod.POST)
    @ResponseBody
    public SubmissionReview newSubmissionReview(@RequestBody SubmissionReview submissionReview) {
        submissionReviewService.saveSubmissionReview(submissionReview);
        return submissionReviewRepository.findById(submissionReview.getId());
    }

    @RequestMapping(value = "/web/rest/SubmissionReview", method = RequestMethod.GET)
    @ResponseBody
    public List<SubmissionReview> listSubmissionReviews() {
        return new java.util.ArrayList<SubmissionReview>(submissionReviewService.findAll());
    }

    @RequestMapping(value = "/web/rest/SubmissionReview/{submissionReview_id}", method = RequestMethod.GET)
    @ResponseBody
    public SubmissionReview loadSubmissionReview(@PathVariable Integer submissionReview_id) {
        return submissionReviewService.findById(submissionReview_id);
    }

    @RequestMapping(value = "/web/rest/SubmissionReview/Delete/{submissionReview_id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteSubmissionReview(@PathVariable Integer submissionReview_id) {
        return submissionReviewService.deleteSubmissionReview(submissionReview_id);
    }

    @RequestMapping(value = "/web/rest/SubmissionReview/Page/{page}", method = RequestMethod.GET)
    @ResponseBody
    public Page<SubmissionReview> findAllPaged(@PathVariable Integer page) {
        Sort sort = new Sort(new Sort.Order(Direction.DESC, "id"));
        Pageable pageable = new PageRequest(page, 5, sort);
        return submissionReviewRepository.findAll(pageable);
    }

    @RequestMapping(value = "/web/rest/SubmissionReview/Page/{page}/Sort/{sortField}/Direction/{direction}", method = RequestMethod.GET)
    @ResponseBody
    public Page<SubmissionReview> findAllPagedSorted(@PathVariable Integer page, @PathVariable String sortField, @PathVariable int direction) {
        Sort sort;
        if (direction == 1)
            sort = Sort.by(sortField).descending();
        else
            sort = Sort.by(sortField).ascending();
        Pageable sortedPaged = PageRequest.of(page, 10, sort);
        return submissionReviewRepository.findAll(sortedPaged);
    }

    @RequestMapping(value = "/web/rest/SubmissionReview/AssignmentSubmission/{submission_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<SubmissionReview> getAllByAssignmentSubmissionId(@PathVariable("submission_id") Integer submissionId) {
        return new java.util.ArrayList<SubmissionReview>(submissionReviewService.findAllByAssignmentSubmissionId(submissionId));
    }

    @RequestMapping(value = "/web/rest/SubmissionReview/ReviewedBy/{batchModuleTrainer_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<SubmissionReview> getAllByReviewedById(@PathVariable("batchModuleTrainer_id") Integer batchModuleTrainerId) {
        return new java.util.ArrayList<SubmissionReview>(submissionReviewService.findAllByReviewedById(batchModuleTrainerId));
    }

    @RequestMapping(value = "/web/rest/SubmissionReview/Status/{status}", method = RequestMethod.GET)
    @ResponseBody
    public List<SubmissionReview> getAllByStatus(@PathVariable("status") String status) {
        return new java.util.ArrayList<SubmissionReview>(submissionReviewService.findAllByStatus(status));
    }

    @RequestMapping(value = "/web/rest/SubmissionReview/Batch/{batch_id}", method = RequestMethod.GET)
    @ResponseBody
    public List<SubmissionReview> getAllByBatchId(@PathVariable("batch_id") Integer batchId) {
        return submissionReviewService.findAllByBatchId(batchId);
    }
}