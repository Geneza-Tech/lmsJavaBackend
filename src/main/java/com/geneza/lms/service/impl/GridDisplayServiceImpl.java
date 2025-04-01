package com.geneza.lms.service.impl;
import com.geneza.lms.domain.GridDisplay;
import com.geneza.lms.service.GridDisplayService; 
import com.geneza.lms.domain.Person;
import com.geneza.lms.persistence.PersonRepository;import com.geneza.lms.domain.Course;
import com.geneza.lms.persistence.CourseRepository;import com.geneza.lms.domain.Module;
import com.geneza.lms.persistence.ModuleRepository;import com.geneza.lms.domain.Batch;
import com.geneza.lms.persistence.BatchRepository;import com.geneza.lms.domain.Country;
import com.geneza.lms.persistence.CountryRepository;import com.geneza.lms.domain.BatchStatus;
import com.geneza.lms.persistence.BatchStatusRepository;import com.geneza.lms.domain.Enrollment;
import com.geneza.lms.persistence.EnrollmentRepository;import com.geneza.lms.domain.Attendance;
import com.geneza.lms.persistence.AttendanceRepository;import com.geneza.lms.domain.Assignment;
import com.geneza.lms.persistence.AssignmentRepository;import com.geneza.lms.domain.AssignmentSubmission;
import com.geneza.lms.persistence.AssignmentSubmissionRepository;import com.geneza.lms.domain.SubmissionStatus;
import com.geneza.lms.persistence.SubmissionStatusRepository;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("GridDisplayService")
@Transactional
public class GridDisplayServiceImpl implements GridDisplayService {

    public GridDisplayServiceImpl() {
    }
   
@Autowired
	private PersonRepository personRepository;@Autowired
	private CourseRepository courseRepository;@Autowired
	private ModuleRepository moduleRepository;@Autowired
	private BatchRepository batchRepository;@Autowired
	private CountryRepository countryRepository;@Autowired
	private BatchStatusRepository batchStatusRepository;@Autowired
	private EnrollmentRepository enrollmentRepository;@Autowired
	private AttendanceRepository attendanceRepository;@Autowired
	private AssignmentRepository assignmentRepository;@Autowired
	private AssignmentSubmissionRepository assignmentSubmissionRepository;@Autowired
	private SubmissionStatusRepository submissionStatusRepository;

    @Transactional
    public GridDisplay getListItems(String gridTag, Integer param1, Integer param2, Integer param3) {
       switch (gridTag){

       case "Person":{
				List<Person> persons = personRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(persons);
			     return gridDisplay;	
			}case "Course":{
				List<Course> courses = courseRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(courses);
			     return gridDisplay;	
			}case "Module":{
				List<Module> modules = moduleRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(modules);
			     return gridDisplay;	
			}case "Batch":{
				List<Batch> batchs = batchRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(batchs);
			     return gridDisplay;	
			}case "Country":{
				List<Country> countrys = countryRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(countrys);
			     return gridDisplay;	
			}case "BatchStatus":{
				List<BatchStatus> batchStatuss = batchStatusRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(batchStatuss);
			     return gridDisplay;	
			}case "Enrollment":{
				List<Enrollment> enrollments = enrollmentRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(enrollments);
			     return gridDisplay;	
			}case "Attendance":{
				List<Attendance> attendances = attendanceRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(attendances);
			     return gridDisplay;	
			}case "Assignment":{
				List<Assignment> assignments = assignmentRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(assignments);
			     return gridDisplay;	
			}case "AssignmentSubmission":{
				List<AssignmentSubmission> assignmentSubmissions = assignmentSubmissionRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(assignmentSubmissions);
			     return gridDisplay;	
			}case "SubmissionStatus":{
				List<SubmissionStatus> submissionStatuss = submissionStatusRepository.findAll();
				 GridDisplay gridDisplay = new GridDisplay(); 
			     gridDisplay.setContent(submissionStatuss);
			     return gridDisplay;	
			}     

       }
      return null;
    }

}