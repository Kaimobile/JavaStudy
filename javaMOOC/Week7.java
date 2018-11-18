package week7;

import java.util.LinkedList;
import java.util.List;


class PasswordException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public PasswordException(String str) {
		super(str);
	}
	
}
class MoneyException extends Exception {
	
	private static final long serialVersionUID = 2L;

	public MoneyException(String str) {
		super(str);
	}
	
}

class Account {
	String userName;
	private String password;
	private int remain;
	public Account(String username, String password , int remain ) {
		this.userName = username;
		this.password = password;
		this.remain = remain;
	}
	public Account(String username, String password) {
		this.userName = username;
		this.password = password;
		this.remain = 0;
	}
	public Account(String username) {
		this.userName = username;
		this.password = "000000";
		this.remain = 0;
	}
	public void moneyIn(int money) {
		this.remain = this.remain + money;
		System.out.println(money+" has been saved successfully");
	}
	public void moneyOut(String pass, int money) throws PasswordException, MoneyException{
		if(pass != this.password) {
			throw new PasswordException("Wrong Password!");
		}else{
			if(money > this.remain) {
				throw new MoneyException("Not enough money!");
			}else {
				this.remain = this.remain - money;
				System.out.println(money+" has been withdrawed successfully");
			}
		}
	}
	public void showRemain(String pass) throws PasswordException{
		if(pass == this.password) {
			System.out.println("The account remains "+this.remain);
		}else {
			throw new PasswordException("Wrong Password!");
		}
		
	}
	public void changePassword(String oldPass, String newPass) throws PasswordException{
		if(oldPass != this.password) {
			throw new PasswordException("Wrong Password!");
		}else {
			this.password = newPass;
			System.out.println("Password changed successfully");
		}
	}
}
class Bank {
	String bankName;
	List<Account> allAccount = new LinkedList<Account>();
	public Bank() {
		this.bankName = "ABC";
	}
	public Bank(String bankName) {
		this.bankName = bankName;
	}
	public void addAcc(String username, String pass, int remain) {
		allAccount.add(new Account(username, pass, remain));
	}
	public void addAcc(String username, String pass) {
		allAccount.add(new Account(username, pass));
	}
	public void addAcc(String username) {
		allAccount.add(new Account(username));
	}
	public Account searchAcc(String username) {
		for(Account acc : allAccount) {
			if(acc.userName.equals(username)) {
				return acc;
			}
		}
		return null;
	}
}
class Test{
	Bank bankA = new Bank();
	public Test() {
		super();
	}
	public void addAcc5() {
		bankA.addAcc("LiMing");
		bankA.addAcc("JingJing","123456");
		bankA.addAcc("Kai","090909",900);
		bankA.addAcc("Mercy","111111",10000);
		bankA.addAcc("Avery");
	}
	public void test1() {
		bankA.searchAcc("LiMing").moneyIn(100);
		try{
			bankA.searchAcc("LiMing").showRemain("000000");
		}catch (PasswordException e) {
			e.printStackTrace();
		}
		try {
			bankA.searchAcc("LiMing").changePassword("111111", "111222");
		}catch (PasswordException e) {
			e.printStackTrace();
		}
		try {
			bankA.searchAcc("LiMing").changePassword("000000", "333333");
		}catch (PasswordException e) {
			e.printStackTrace();
		}
		try {
			bankA.searchAcc("LiMing").moneyOut("333333", 1000);
		}catch(PasswordException e) {
			e.printStackTrace();
		}catch (MoneyException f) {
			f.printStackTrace();
		}
		try{
			bankA.searchAcc("LiMing").showRemain("333333");
		}catch (PasswordException e) {
			e.printStackTrace();
		}
	}
	public void test2() {
		bankA.searchAcc("Mercy").moneyIn(100000);
		try {
			bankA.searchAcc("Mercy").moneyOut("111111", 999);
		}catch(PasswordException e) {
			e.printStackTrace();
		}catch (MoneyException f) {
			f.printStackTrace();
		}
		try{
			bankA.searchAcc("Mercy").showRemain("111111");
		}catch (PasswordException e) {
			e.printStackTrace();
		}
	}
}
public class Week7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test a = new Test();
		a.addAcc5();
		a.test1();
		a.test2();
	}

}
