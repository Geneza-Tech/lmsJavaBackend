package com.geneza.lms.service.impl;

import com.geneza.lms.domain.Attachment;
import com.geneza.lms.persistence.AttachmentRepository;
import com.geneza.lms.service.AttachmentService;
import com.geneza.lms.service.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final FileStorageService fileStorageService;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository,
                                 FileStorageService fileStorageService) {
        this.attachmentRepository = attachmentRepository;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Attachment upload(MultipartFile file, Integer linkId, String linkType, String type) throws Exception {
        String fileUrl = fileStorageService.uploadFile(file);

        Attachment attachment = new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setFileUrl(fileUrl);
        attachment.setLinkId(linkId);
        attachment.setLinkType(linkType);
        attachment.setType(type);

        return attachmentRepository.save(attachment);
    }

    @Override
    public Attachment get(Integer id) {
        return attachmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Attachment> list() {
        return attachmentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        attachmentRepository.deleteById(id);
    }

    @Override
    public List<Attachment> getByLinkId(Integer linkId) {
        return attachmentRepository.findByLinkId(linkId);
    }

    @Override
    public List<Attachment> getByLinkTypeAndLinkId(String linkType, Integer linkId) {
        return attachmentRepository.findByLinkTypeAndLinkId(linkType, linkId);
    }
}