package Test;

import java.io.Serializable;

@SuppressWarnings("serial")
public class NewAcBean implements Serializable
{
    private String uname,pword,repword,address;
    private double amount;
    private long phone;
    private int acno;
    public NewAcBean()
    {
    	
    }
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPword() {
		return pword;
	}
	public void setPword(String pword) {
		this.pword = pword;
	}
	public String getRepword() {
		return repword;
	}
	public void setRepword(String repword) {
		this.repword = repword;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAcno() {
		return acno;
	}
	public void setAcno(int acno) {
		this.acno = acno;
	}
	@Override
	public String toString() {
		return "NewAcBean [uname=" + uname + ", pword=" + pword + ", repword=" + repword + ", address=" + address
				+ ", amount=" + amount + ", phone=" + phone + ", acno=" + acno + "]";
	}
	
    
}
