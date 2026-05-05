package com.geneza.lms.persistence;
import java.util.List; // ✅ ADD THIS IMPORT

import com.geneza.lms.domain.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
        List<Attachment> findByLinkId(Integer linkId);
        List<Attachment> findByLinkTypeAndLinkId(String linkType, Integer linkId);
    List<Attachment> findByLinkType(String linkType);
}
