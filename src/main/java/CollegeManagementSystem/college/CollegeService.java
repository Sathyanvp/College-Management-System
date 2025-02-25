package CollegeManagementSystem.college;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class CollegeService {
	
	private CollegeRepository collegeRepo;

	public CollegeService(CollegeRepository collegeRepo) {
		super();
		this.collegeRepo = collegeRepo;
	}

	
	public ResponseEntity<College> create(College collegeName) {
		try {
		 collegeRepo.save(collegeName);
		 return new ResponseEntity<>(collegeName,HttpStatus.CREATED);
		 }
		catch(Exception e) {
			return new ResponseEntity<>(collegeName,HttpStatus.CONFLICT);
		}
	}

	
	public List<College> showAllColleges() {
		return collegeRepo.findAll();
		
	}

	
	public ResponseEntity<College> search(String collegeName) {
		College collegeToSearch = collegeRepo.findBycollegeName(collegeName);
		return new ResponseEntity<>(collegeToSearch,HttpStatus.ACCEPTED);
			}

	
	public ResponseEntity<String> deleteCollege(String collegeName) {
		try {
			 collegeRepo.findBycollegeName(collegeName);
			 return new ResponseEntity<>("Deleted successfully",HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Error in deleting, please make sure college name is correct",HttpStatus.CONFLICT);
		}
		
	}

	

}
