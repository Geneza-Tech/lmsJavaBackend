package com.geneza.lms.service.impl;
import com.geneza.lms.persistence.ModuleRepository;
import com.geneza.lms.domain.Module;
import com.geneza.lms.service.ModuleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("ModuleService")
@Transactional
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;
    public ModuleServiceImpl() {
    }

    @Transactional
    public Module findById(Integer id) {
        return moduleRepository.findById(id);
    }

    @Transactional
    public List<Module> findAll() {
        return moduleRepository.findAll();
    }
     
    @Transactional
    public void saveModule(Module module) {
        Module existingModule = moduleRepository.findById(module.getId());
        if (existingModule != null) {
        if (existingModule != module) {      
        existingModule.setId(module.getId());
                existingModule.setModule(module.getModule());
                existingModule.setDescription(module.getDescription());
                existingModule.setCourse(module.getCourse());
        }
        module = moduleRepository.save(existingModule);
    }else{
        module = moduleRepository.save(module);
        }
        moduleRepository.flush();
    }

    public boolean deleteModule(Integer moduleId) {
        Module module = moduleRepository.findById(moduleId);
        if(module!=null) {
            moduleRepository.delete(module);
            return true;
        }else {
            return false;
        }
    }@Transactional
    public List<Module> findAllByCourseId(Integer  courseId) {
        return new java.util.ArrayList<Module>(moduleRepository.findAllByCourseId(courseId));
    }

    

}