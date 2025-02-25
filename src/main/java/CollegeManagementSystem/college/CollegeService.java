package CollegeManagementSystem.college;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class CollegeService {
	
	private CollegeRepository collegeRepo;

	public CollegeService(CollegeRepository collegeRepo) {
		super();
		this.collegeRepo = collegeRepo;
	}

	
	public ResponseEntity<College> create(College collegeName) {
		try {
		 College createdCollege = collegeRepo.save(collegeName);
		 return new ResponseEntity<>(createdCollege,HttpStatus.CREATED);
		 }
		catch(Exception e) {
			return new ResponseEntity<>(collegeName,HttpStatus.CONFLICT);
		}
	}

	
	public List<College> showAllColleges() {
		return collegeRepo.findAll();
		
	}

	
	 @Transactional // Add Transactional annotation
	    public ResponseEntity<College> search(String collegeName) {
	        College collegeToSearch = collegeRepo.findBycollegeName(collegeName);
	        if (collegeToSearch != null) {
	            // Eagerly load students (already done due to transactional)
	            collegeToSearch.getStudents().size(); // Trigger loading
	            return new ResponseEntity<>(collegeToSearch, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	
	public ResponseEntity<String> deleteCollege(String collegeName) {
		try {
			 collegeRepo.deleteBycollegeName(collegeName);
			 return new ResponseEntity<>("Deleted successfully",HttpStatus.ACCEPTED);
		}
		catch(Exception e) {
			return new ResponseEntity<>("Error in deleting, please make sure college name is correct",HttpStatus.CONFLICT);
		}
		
	}

	

}
