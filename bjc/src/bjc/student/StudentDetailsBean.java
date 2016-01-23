package bjc.student;

import java.util.Date;

public class StudentDetailsBean {
	
	
	String section  ;
	public StudentDetailsBean(String section2, String studentName2,
			String schoolName2, String fatherName2, String occupation2,
			String joined2, String contactNumber2, String doorNumber2,
			String village2, String city2, String district2,String remarks2) {
		
		this.section =section2;
		this.studentName =studentName2;
		this.schoolName =schoolName2;
		this.fatherName =fatherName2;
		this.occupation = occupation2;
		this.joined = joined2;
		this.contactNumber = contactNumber2;
		this.doorNumber = doorNumber2;
		this.village = village2;
		this.city = city2;
		this.district = district2;
		this.remarks = remarks2;
	//	this.createdOn = createdOn;
		
		// TODO Auto-generated constructor stub
	}
	
	public StudentDetailsBean(int id2,String section2, String studentName2,
			String schoolName2, String fatherName2, String occupation2,
			String joined2, String contactNumber2, String doorNumber2,
			String village2, String city2, String district2,String remarks2) {
		
		this.id =id2;
		this.section =section2;
		this.studentName =studentName2;
		this.schoolName =schoolName2;
		this.fatherName =fatherName2;
		this.occupation = occupation2;
		this.joined = joined2;
		this.contactNumber = contactNumber2;
		this.doorNumber = doorNumber2;
		this.village = village2;
		this.city = city2;
		this.district = district2;
		this.remarks = remarks2;
	//	this.createdOn = createdOn;
		
		// TODO Auto-generated constructor stub
	}
	
	public StudentDetailsBean(String section2, String studentName2,
			String schoolName2, String fatherName2, String village2
			) {
		this.section =section2;
		this.studentName =studentName2;
		this.schoolName =schoolName2;
		this.fatherName =fatherName2;
		this.village = village2;
		
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getJoined() {
		return joined;
	}
	public void setJoined(String joined) {
		this.joined = joined;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDoorNumber() {
		return doorNumber;
	}
	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRemarks() {
		return remarks;
	}
	
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "StudentDetails [section=" + section + ", studentName="
				+ studentName + ", schoolName=" + schoolName + ", fatherName="
				+ fatherName + ", occupation=" + occupation + ", joined="
				+ joined + ", contactNumber=" + contactNumber + ", doorNumber="
				+ doorNumber + ", village=" + village + ", city=" + city
				+ ", district=" + district + "]";
	}
	
	
	int id;
	String studentName  ;
	String schoolName  ;
	String fatherName  ;
	String occupation  ;
	String joined  ;
	String contactNumber  ;
	String doorNumber  ;
	String village  ;
	String city  ;
	String district  ;
	Date createdOn;
	String remarks;


}
