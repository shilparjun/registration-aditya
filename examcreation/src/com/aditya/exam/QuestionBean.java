package com.aditya.exam;

public class QuestionBean implements java.io.Serializable {
	
	
	public QuestionBean(int id,int yearjoined,String branch,  String subject,
			String chapter, String complexity, int marks,String question,String answer,
			String type,String option1,	String option2, String option3, String option4, 
			 int semester) {
		
		this.id = id;
		this.yearjoined = yearjoined;
		this.branch = branch;
		this.subject = subject;
		this.chapter = chapter;
		this.complexity = complexity;
		this.marks=marks;
		this.question = question;
		this.answer = answer;
		this.type = type;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.semester = semester;
		
	}
	public QuestionBean() {
		
	}
	
	public QuestionBean(int id, String paperName, String type, int semester,
			String branch, String subject, int yearjoined) {
		this.id=id;
		this.paperName = paperName;
		this.type=type;
		this.semester=semester;
		this.branch = branch;
		this.subject=subject;
		this.yearjoined = yearjoined;
	}
	public QuestionBean(int id, int yearjoined,String branch, String subject,String question, String answer,String type, int semester)
	 {
		this.id=id;
		this.yearjoined = yearjoined;
		this.branch = branch;
		this.subject=subject;	
		this.question = question;
		this.answer = answer;
		this.type=type;
		this.semester=semester;	

	 }

	
	int yearjoined;
	String branch;
	String paperName;
	String group;
	String subject;
	String chapter; 
	String complexity;
	int marks;
	String question;
	String option1;
	String option2;
	String option3; 
	String option4; 
	String answer;
	String type; 
	int semester;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYearjoined() {
		return yearjoined;
	}
	public void setYearjoined(int yearjoined) {
		this.yearjoined = yearjoined;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getChapter() {
		return chapter;
	}
	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	public String getComplexity() {
		return complexity;
	}
	public void setComplexity(String complexity) {
		this.complexity = complexity;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getSemester() {
		return semester;
	}
	public void setSemester(int semester) {
		this.semester = semester;
	}
	int id;
	@Override
	public String toString() {
		return "QuestionBean [id=" + id + ", yearjoined=" + yearjoined
				+ ", group=" + group + ", subject=" + subject + ", chapter="
				+ chapter + ", complexity=" + complexity + ", marks=" + marks
				+ ", question=" + question + ", option1=" + option1
				+ ", option2=" + option2 + ", option3=" + option3
				+ ", option4=" + option4 + ", answer=" + answer + ", type="
				+ type + ", semester=" + semester + "]";
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getPaperName() {
		return paperName;
	}
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

}
