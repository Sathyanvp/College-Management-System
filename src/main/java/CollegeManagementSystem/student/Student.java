package CollegeManagementSystem.student;

import java.util.regex.Matcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import CollegeManagementSystem.college.College;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.regex.Pattern;


@Entity
@Table
public class Student {
	
	//Fields

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique=true)
    private Long rollNo;
	
	@Column
	private String name;
    
    @Column(unique=true)
    private String Email;
    
    @Column
    private String department;
    
    
    @ManyToOne
	@JoinColumn(name="college_id")
    private College collegeName;
    
    @Column
    private Long phoneNum;
    
    @Column
    private Long year;
    
    
    //Default Constructor
    
    public Student() {
        
    }
    
    
    //Constructors
    
 	public Student( Long rollNo, String name, String email, String department, College collegeName, Long phoneNum,
 			Long year) {
 		super();
 		
 		this.rollNo = rollNo;
 		this.name = name;
 		this.Email = email;
 		this.department = department;
 		this.collegeName = collegeName;
 		this.phoneNum = phoneNum;
 		this.year = year;
 	}

 	
 	//setters
 	
	public void setId(int id) {
		this.id = id;
	}

	public void setRollNo(Long rollNo) {
		this.rollNo = rollNo;
	}

	public void setName(String name) {
		this.name = name;
	}
	
 public void setEmail(String email) {
	    if (!isValidEmail(email)) {
	       throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email format");
	        }
	      Email = email;
	   }
	   
	public void setDepartment(String department) {
		this.department = department;
	}

	public void setPhoneNum(Long phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setCollegeName(College collegeName) {
		this.collegeName = collegeName;
	}


	public void setYear(Long year) {
		this.year = year;
	}
	
	
	//getters
	
	public Long getRollNo() {
		return rollNo;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public College getCollegeName() {
		return collegeName;
	}
	

	public Long getPhoneNum() {
		return phoneNum;
	}
	
	public Long getYear() {
		return year;
	}
	
	
	
	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", name=" + name + ", Email=" + Email + ", department=" + department
				+ ", college=" + collegeName + ", phoneNum=" + phoneNum + ", year=" + year + "]";
	}
	
	  private boolean isValidEmail(String email) {
	      String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	      Pattern pattern = Pattern.compile(regex);
	      Matcher matcher = pattern.matcher(email);
	      return matcher.matches();
	    }
   
}
