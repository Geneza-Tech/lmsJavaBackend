package com.geneza.lms.service;

import com.geneza.lms.domain.Attachment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AttachmentService {

    Attachment upload(MultipartFile file, Integer linkId) throws Exception;

    Attachment get(Integer id);

    List<Attachment> list();

    List<Attachment> getByLinkId(Integer linkId);

    void delete(Integer id);
}
