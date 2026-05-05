package com.geneza.lms.web.rest;

import com.geneza.lms.domain.Attachment;
import com.geneza.lms.domain.AttachmentLinkType;
import com.geneza.lms.service.AttachmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@RestController
@RequestMapping("/api/attachments")
public class AttachmentRestController {

    private final AttachmentService attachmentService;

    public AttachmentRestController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    // Generic upload — caller passes linkType explicitly
    @PostMapping("/upload")
    public ResponseEntity<Attachment> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("linkId") Integer linkId,
            @RequestParam("linkType") String linkType,
            @RequestParam("type") String type
    ) throws Exception {
        return ResponseEntity.ok(attachmentService.upload(file, linkId, linkType, type));
    }

    // Typed convenience upload endpoints — no need to pass linkType from frontend
    @PostMapping("/upload/assignment/{assignmentId}")
    public ResponseEntity<Attachment> uploadForAssignment(
            @RequestParam("file") MultipartFile file,
            @PathVariable Integer assignmentId
    ) throws Exception {
        return ResponseEntity.ok(attachmentService.upload(file, assignmentId, AttachmentLinkType.ASSIGNMENT, "assignment"));
    }

    @PostMapping("/upload/submission/{submissionId}")
    public ResponseEntity<Attachment> uploadForSubmission(
            @RequestParam("file") MultipartFile file,
            @PathVariable Integer submissionId
    ) throws Exception {
        return ResponseEntity.ok(attachmentService.upload(file, submissionId, AttachmentLinkType.ASSIGNMENT_SUBMISSION, "submission"));
    }

    @PostMapping("/upload/review/{reviewId}")
    public ResponseEntity<Attachment> uploadForReview(
            @RequestParam("file") MultipartFile file,
            @PathVariable Integer reviewId
    ) throws Exception {
        return ResponseEntity.ok(attachmentService.upload(file, reviewId, AttachmentLinkType.SUBMISSION_REVIEW, "review"));
    }

    // Typed fetch endpoints
    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<List<Attachment>> getByAssignment(@PathVariable Integer assignmentId) {
        return ResponseEntity.ok(attachmentService.getByLinkTypeAndLinkId(AttachmentLinkType.ASSIGNMENT, assignmentId));
    }

    @GetMapping("/submission/{submissionId}")
    public ResponseEntity<List<Attachment>> getBySubmission(@PathVariable Integer submissionId) {
        return ResponseEntity.ok(attachmentService.getByLinkTypeAndLinkId(AttachmentLinkType.ASSIGNMENT_SUBMISSION, submissionId));
    }

    @GetMapping("/review/{reviewId}")
    public ResponseEntity<List<Attachment>> getByReview(@PathVariable Integer reviewId) {
        return ResponseEntity.ok(attachmentService.getByLinkTypeAndLinkId(AttachmentLinkType.SUBMISSION_REVIEW, reviewId));
    }

    // Existing endpoints unchanged
    @GetMapping("/{id}")
    public ResponseEntity<Attachment> getAttachment(@PathVariable Integer id) {
        Attachment attachment = attachmentService.get(id);
        return attachment != null ? ResponseEntity.ok(attachment) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Attachment>> getAllAttachments() {
        return ResponseEntity.ok(attachmentService.list());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAttachment(@PathVariable Integer id) {
        attachmentService.delete(id);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/bylinkId/{linkId}")
    public ResponseEntity<List<Attachment>> getAttachmentsByLinkId(@PathVariable Integer linkId) {
        return ResponseEntity.ok(attachmentService.getByLinkId(linkId));
    }
}