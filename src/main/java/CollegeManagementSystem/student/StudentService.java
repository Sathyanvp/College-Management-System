package CollegeManagementSystem.student;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	

    private StudentRepository studentrepo;

	public StudentService(StudentRepository studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}


	 public  ResponseEntity<Student> create(Student student) {
		try {
			Student createdStudent=studentrepo.save(student);
	        return new ResponseEntity<>( createdStudent, HttpStatus.CREATED);}
		catch(Exception e) {
			return new ResponseEntity<>(student,HttpStatus.CONFLICT);
			
		}
	 }

	public ResponseEntity<Student> search(Long rollNo) {
	    try {
		Student searchedstudent=studentrepo.findByrollNo(rollNo);
		return new ResponseEntity<>(searchedstudent,HttpStatus.FOUND);}
	    catch(Exception e) {
	    	 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	
	public List<Student> showAllStudents(){
		
		return studentrepo.findAll();
		
	}


	public ResponseEntity<String> deleteStudentprofile(Long  rollNo) {
		    Student tempstud= studentrepo.findByrollNo(rollNo);      
		   
		    try {
		     Long idToDelete= (long) tempstud.getId();
             studentrepo.deleteById( idToDelete);
             return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
		    }
            catch(Exception e) {
                return new ResponseEntity<>("Error deleting student", HttpStatus.INTERNAL_SERVER_ERROR); 
            }
	}
	
	
    
    
}
