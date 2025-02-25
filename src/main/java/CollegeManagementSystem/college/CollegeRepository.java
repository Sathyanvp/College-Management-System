package CollegeManagementSystem.college;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public interface CollegeRepository extends JpaRepository<College,Long>{
	College findBycollegeName(String collegeName);

}
