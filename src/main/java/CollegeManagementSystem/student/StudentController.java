package CollegeManagementSystem.student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	
	private StudentService studserv;
	@Autowired
	public StudentController(StudentService studserv) {
		super();
		this.studserv = studserv;
	}


	 @PostMapping("/students")
	  public ResponseEntity<Student> createStudent(@RequestBody Student student) {
	        return studserv.create(student); 
	    }
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studserv.showAllStudents();
	}
		
	
	@GetMapping("/students/{rollNo}")
	public ResponseEntity<Student> searchStudent(@PathVariable Long rollNo){
		return studserv.search(rollNo);
		
	}
	 @DeleteMapping("/students/{rollNo}") 
	    public ResponseEntity<String> deletestudent(@PathVariable Long rollNo) { 
	        return studserv.deleteStudentprofile(rollNo); 
	}
	

}
