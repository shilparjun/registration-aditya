package bjc.student;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class FeesBean {
	
	
	public FeesBean(int sno,
				    String studentid,
					int annualFeesPaid,
					int busfeesPaid ,
					String dateGiven,
					String nextInstallment,
					String givento,
					String paidBy, 
					String remarks

					) {
		this.sno= sno;
		this.studentid = studentid;
	    this.annualFeesPaid = annualFeesPaid;
		this.busfeesPaid = busfeesPaid;
		this.dateGiven = dateGiven;
		this.nextInstallment = nextInstallment;
		this.givento = givento;
		this.paidBy=paidBy;
		this.remarks=remarks;
	}
	
	public FeesBean(
		    String studentid,
			int annualFeesPaid,
			int busfeesPaid ,
			String nextInstallment,
			String givento,
			String paidBy, 
			String remarks

			) {
			this.studentid = studentid;
			this.annualFeesPaid = annualFeesPaid;
			this.busfeesPaid = busfeesPaid;
			this.nextInstallment = nextInstallment;
			this.givento = givento;
			this.paidBy=paidBy;
			this.remarks=remarks;
			}
	

	
	int sno;
	String studentid;
	int annualFeesPaid;
	int busfeesPaid ;
	String dateGiven;
	String nextInstallment;
	String givento;
	String paidBy;
	String remarks;
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public int getAnnualFeesPaid() {
		return annualFeesPaid;
	}
	public void setAnnualFeesPaid(int annualFeesPaid) {
		this.annualFeesPaid = annualFeesPaid;
	}
	public int getBusfeesPaid() {
		return busfeesPaid;
	}
	public void setBusfeesPaid(int busfeesPaid) {
		this.busfeesPaid = busfeesPaid;
	}
	public String getDateGiven() {
		return dateGiven;
	}
	public void setDateGiven(String dateGiven) {
		this.dateGiven = dateGiven;
	}
	public String getNextInstallment() {
		return nextInstallment;
	}
	public void setNextInstallment(String nextInstallment) {
		this.nextInstallment = nextInstallment;
	}
	public String getGivento() {
		return givento;
	}
	public void setGivento(String givento) {
		this.givento = givento;
	}
	public String getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(String paidBy) {
		this.paidBy = paidBy;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
