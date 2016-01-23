package bjc.student;

import java.util.ArrayList;

public class StudentsBean {

	String sno;
	String studentid = null;
	String firstName = null;
	String lastName = null;
	String group = null;
	String fatherName = null;
	String contactNumber;
	String secondaryNumber;
	String section = null;
	String schoolStudied = null;
	String schoolGrade = null;
	String address = null;
	String town = null;
	String feesSet = null;
	MarksBean marksBean = null;
	ArrayList feeList = null;
	int studentFees;
	int busFees;
	String hostel = null;
	int balance;
	int busFeeBalance;	
	int tutionFeePaid;
	int busFeePaid;
	int tutionFeesPaidAmount; 
	int busFeesPaidAmount;
	
	
	public int getTutionFeePaid() {
		return tutionFeePaid;
	}

	public void setTutionFeePaid(int tutionFeePaid) {
		this.tutionFeePaid = tutionFeePaid;
	}

	public int getBusFeePaid() {
		return busFeePaid;
	}

	public void setBusFeePaid(int busFeePaid) {
		this.busFeePaid = busFeePaid;
	}

	int studentYear;
	FeesBean feeBean = null;
	
	public StudentsBean(
			String sno,
			String section,
			String studentid,
			String group,
			int studentYear,
			String firstName,
			String lastName,
			String fatherName,
			String fatherOccupation,
			String contactNumber, 
			String secondaryNumber, 
			String address,
			String town,  
			String schoolStudied,
			String schoolGrade, 
			String hostel,
			int studentFees,
			int busFees,
			String feesSet ) {
		this.sno = sno;
		this.section = section;		
		this.studentid = studentid;
		this.group = group;
		this.studentYear = studentYear;		
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.fatherOccupation = fatherOccupation;		
		this.contactNumber = contactNumber;
		this.secondaryNumber = secondaryNumber;
		this.address = address;
		this.town = town;		
		this.schoolStudied = schoolStudied;
		this.schoolGrade = schoolGrade;		
		this.hostel = hostel;
		this.studentFees = studentFees;
		this.busFees = busFees;
		this.feesSet=feesSet;
	}

	public StudentsBean(String firstName, String lastName, String fatherName,
			String contactNumber, String town, String hostel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.contactNumber = contactNumber;
		this.town = town;
		this.hostel = hostel;
		/*
		 * this.secondaryNumber=secondaryNumber; this.sno= sno; this.studentid =
		 * studentid; this.group = group; this.schoolStudied=schoolStudied;
		 * this.schoolGrade=schoolGrade; this.address = address; this.section =
		 * section; this.year=year; this.fatherOccupation = fatherOccupation;
		 * this.fees=fees;
		 */
	}
	public StudentsBean(String firstName, String lastName,
			String contactNumber, String address, String hostel, int studentFees,
			FeesBean feeBean) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.address = address;
		this.hostel = hostel;
		this.studentFees = studentFees;
		this.feeBean = feeBean;
	}

	public StudentsBean() {
		// TODO Auto-generated constructor stub
	}

	public StudentsBean(String sno, String section, String firstName) {
		this.sno = sno;
		this.section=section;
		this.firstName=firstName;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getSecondaryNumber() {
		return secondaryNumber;
	}

	public void setSecondaryNumber(String secondaryNumber) {
		this.secondaryNumber = secondaryNumber;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getSchoolStudied() {
		return schoolStudied;
	}

	public void setSchoolStudied(String schoolStudied) {
		this.schoolStudied = schoolStudied;
	}

	public String getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(String schoolGrade) {
		this.schoolGrade = schoolGrade;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public int getYear() {
		return studentYear;
	}

	public void setYear(int studentYear) {
		this.studentYear = studentYear;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String ftherOccupation) {
		this.fatherOccupation = ftherOccupation;
	}

	public ArrayList getFeeList() {
		return feeList;
	}

	public void setFeeList(ArrayList feeList) {
		this.feeList = feeList;
	}



	public FeesBean getFeeBean() {
		return feeBean;
	}

	public void setFeeBean(FeesBean feeBean) {
		this.feeBean = feeBean;
	}

	String fatherOccupation = null;

	public String getHostel() {
		return hostel;
	}

	public void setHostel(String hostel) {
		this.hostel = hostel;
	}


	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setMarksBean(MarksBean marksBean) {
		this.marksBean = marksBean;
	}

	public MarksBean getMarksBean() {
		return marksBean;
	}

	public String getFeesSet() {
		return feesSet;
	}

	public void setFeesSet(String feesSet) {
		this.feesSet = feesSet;
	}

	public int getStudentYear() {
		return studentYear;
	}

	public void setStudentYear(int studentYear) {
		this.studentYear = studentYear;
	}

	public int getStudentFees() {
		return studentFees;
	}

	public void setStudentFees(int studentFees) {
		this.studentFees = studentFees;
	}

	public int getBusFees() {
		return busFees;
	}

	public void setBusFees(int busFees) {
		this.busFees = busFees;
	}

	public int getBusFeeBalance() {
		return busFeeBalance;
	}

	public void setBusFeeBalance(int busFeeBalance) {
		this.busFeeBalance = busFeeBalance;
	}

	public void setTutionFeesPaidAmount(int tutionFeesPaidAmount) {
		this.tutionFeesPaidAmount = tutionFeesPaidAmount;		
	}
	
	public int getTutionFeesPaidAmount() {
		return tutionFeesPaidAmount;		
	}
	
	public void setBusFeesPaidAmount(int busFeesPaidAmount) {
		this.busFeesPaidAmount = busFeesPaidAmount;		
	}
	
	public int getBusFeesPaidAmount() {
		return busFeesPaidAmount;		
	}	

}
