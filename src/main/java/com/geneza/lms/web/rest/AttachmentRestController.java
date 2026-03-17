package com.geneza.lms.web.rest;

import com.geneza.lms.domain.Attachment;
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

    @PostMapping("/upload")
    public ResponseEntity<Attachment> uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("linkId") Integer linkId
    ) throws Exception {
        Attachment attachment = attachmentService.upload(file, linkId);
        return ResponseEntity.ok(attachment);
    }

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
    public ResponseEntity<List<Attachment>> getAttachmentsByLinkId(
            @PathVariable Integer linkId
    ) {
        List<Attachment> attachments = attachmentService.getByLinkId(linkId);
        return ResponseEntity.ok(attachments);
    }

}
