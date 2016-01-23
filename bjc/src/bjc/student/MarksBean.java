package bjc.student;

import java.sql.Date;

public class MarksBean {
 
	int sno;
    public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getExamtype() {
		return examtype;
	}

	public void setExamtype(String examtype) {
		this.examtype = examtype;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getSanskrit() {
		return sanskrit;
	}

	public void setSanskrit(int sanskrit) {
		this.sanskrit = sanskrit;
	}

	public int getMaths1a() {
		return maths1a;
	}

	public void setMaths1a(int maths1a) {
		this.maths1a = maths1a;
	}

	public int getMaths1b() {
		return maths1b;
	}

	public void setMaths1b(int maths1b) {
		this.maths1b = maths1b;
	}

	public int getBotony() {
		return botony;
	}

	public void setBotony(int botony) {
		this.botony = botony;
	}

	public int getZoology() {
		return zoology;
	}

	public void setZoology(int zoology) {
		this.zoology = zoology;
	}

	public int getPhysics() {
		return physics;
	}

	public void setPhysics(int physics) {
		this.physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getAccounts() {
		return accounts;
	}

	public void setAccounts(int accounts) {
		this.accounts = accounts;
	}

	public int getCommerce() {
		return commerce;
	}

	public void setCommerce(int commerce) {
		this.commerce = commerce;
	}

	public int getCivics() {
		return civics;
	}

	public void setCivics(int civics) {
		this.civics = civics;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	String examtype = null;
    int english;
    int sanskrit;
    int maths1a;
    int maths1b;
    int botony;
    int zoology;
    int physics;
    int chemistry;
    int accounts;
    int commerce;
    int civics;
    String studentid;
    int total ;
    
    String section;
    String firstname;
    
   public  MarksBean ( int sno,
			   String examtype,
			   int english,
			   int sanskrit,
			   int maths1a,
			   int maths1b,
			   int botony,
			   int zoology,
			   int physics,
			   int chemistry,
			   int accounts,
			   int commerce,
			   int civics,
			   String studentid,
			   int total
		   
		   ) {

	   this.sno= sno;
	   this.examtype= examtype;
	   this.english= english;
	   this.sanskrit= sanskrit;
	   this.maths1a= maths1a;
	   this.maths1b= maths1b;
	   this.botony= botony;
	   this.zoology= zoology;
	   this.physics= physics;
	   this.chemistry= chemistry;
	   this.accounts= accounts;
	   this.commerce= commerce;
	   this.civics= civics;
	   this.studentid= studentid;
	   this.total=total;
	   
   }

public MarksBean(
		        String studentid,
		        int english,
				int maths1a,
				int maths1b, 
				int physics,
		        int chemistry,
		        int botony,
		        int zoology,
		        int total,
		        String section,
		        String firstname
		        ) {
				this.studentid = studentid;
				this.english = english;
				this.maths1a = maths1a;
				this.maths1b = maths1b;
				this.physics = physics;
				this.chemistry = chemistry;
				this.botony = botony;
				this.zoology=zoology;
				this.total = total;
				this.section=section;
				this.firstname=firstname;

}

public String getSection() {
	return section;
}

public void setSection(String section) {
	this.section = section;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}


    


}
