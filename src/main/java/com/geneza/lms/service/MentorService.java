package com.geneza.lms.service;
import com.geneza.lms.domain.BatchMentor;
import com.geneza.lms.domain.Mentor;
import java.util.List;

public interface MentorService {
    public Mentor findById(Integer id);
    public void saveMentor(Mentor mentor_1);
    public boolean deleteMentor(Integer mentorId);
    public List<Mentor> findAll();
    public List<Mentor> findAllByMentorId(Integer  mentor);

}