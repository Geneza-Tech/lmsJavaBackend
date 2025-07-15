package com.geneza.lms.service;
import com.geneza.lms.domain.Module;
import java.util.List;

public interface ModuleService {
    public Module findById(Integer id);
    public void saveModule(Module module_1);
    public boolean deleteModule(Integer moduleId);
    public List<Module> findAll();
    public List<Module> findAllByCourseId(Integer  course);
}