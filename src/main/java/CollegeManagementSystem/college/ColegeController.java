package CollegeManagementSystem.college;

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
public class ColegeController {
	

	
	private CollegeService collegeServ;
	@Autowired
    public ColegeController( CollegeService collegeService ) {
		super();
		this.collegeServ = collegeService;
	}



	@PostMapping("/colleges")
	public ResponseEntity<College> createCollege(@RequestBody College collegeName){
		return collegeServ.create(collegeName);
}
	
	@GetMapping("/colleges")
	public List<College> getAllColleges(){
		return collegeServ.showAllColleges();
	}
		
	
	@GetMapping("colleges/{collegeName}")
	public ResponseEntity<College> searchCollege(@PathVariable String collegeName){
		 return collegeServ.search(collegeName);
	
		
	}
	
	@DeleteMapping("/colleges/{CollegeName}")
	public ResponseEntity<String> deletestudent(@PathVariable String collegeName){
		return collegeServ.deleteCollege(collegeName);
	}
	
}
