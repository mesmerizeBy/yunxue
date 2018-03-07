package yunxue.mo;

//购买课时订单

public class BuyclassMo {
	private int buyNo;
	private int stuNo;
	private String buyStuStage;
	private int buyAmount;
	private int buyMoney;
	private String buyState;
	private String buyStuGrade;
	
	
	public String getBuyStuGrade() {
		return buyStuGrade;
	}

	public void setBuyStuGrade(String buyStuGrade) {
		this.buyStuGrade = buyStuGrade;
	}

	public String getBuyStuStage() {
		return buyStuStage;
	}
	public void setBuyStuStage(String buyStuStage) {
		this.buyStuStage = buyStuStage;
	}
	public int getBuyNo() {
		return buyNo;
	}
	public void setBuyNo(int buyNo) {
		this.buyNo = buyNo;
	}
	public int getStuNo() {
		return stuNo;
	}
	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}
	public int getBuyAmount() {
		return buyAmount;
	}
	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}
	public int getBuyMoney() {
		return buyMoney;
	}
	public void setBuyMoney(int buyMoney) {
		this.buyMoney = buyMoney;
	}
	public String getBuyState() {
		return buyState;
	}
	public void setBuyState(String buyState) {
		this.buyState = buyState;
	}

}
