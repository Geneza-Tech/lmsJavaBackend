package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.MentorRepository;
import com.geneza.lms.domain.Mentor;
import com.geneza.lms.service.MentorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("MentorService")
@Transactional
public class MentorServiceImpl implements MentorService {

    @Autowired
    private MentorRepository mentorRepository;
    public MentorServiceImpl() {
    }

    @Transactional
    public Mentor findById(Integer id) {
        return mentorRepository.findById(id);
    }

    @Transactional
    public List<Mentor> findAll() {
        return mentorRepository.findAll();
    }
     
    @Transactional
    public void saveMentor(Mentor mentor) {
        Mentor existingMentor = mentorRepository.findById(mentor.getId());
        if (existingMentor != null) {
        if (existingMentor != mentor) {      
        existingMentor.setId(mentor.getId());
                existingMentor.setMentor(mentor.getMentor());
        }
        mentor = mentorRepository.save(existingMentor);
    }else{
        mentor = mentorRepository.save(mentor);
        }
        mentorRepository.flush();
    }

    public boolean deleteMentor(Integer mentorId) {
        Mentor mentor = mentorRepository.findById(mentorId);
        if(mentor!=null) {
            mentorRepository.delete(mentor);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<Mentor> findAllByMentorId(Integer  mentorId) {
        return new java.util.ArrayList<Mentor>(mentorRepository.findAllByMentorId(mentorId));
    }

    

}