import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class User {
	private String name;
	private String phonenumber;
	private int age;
	private int UserID;
	private static int lastUserID = 0;

	public User(String name, int age, String phonenumber) {
		setID();
		setName(name);
		setAge(age);
		setPhonenumber(phonenumber);
	}

	public void printUinfo() {
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Phone Number: " + phonenumber);
		System.out.println("User ID: " + UserID);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		if (phonenumber.length() == 13) {

			this.phonenumber = phonenumber;
		} 
		else {
			JOptionPane.showMessageDialog(null, "you should enter the phone number like this: \"+***\"");
			GUI.wphtxt.setText("+962");
			GUI.pphtxt.setText("+962");
			this.phonenumber = phonenumber;
		}
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if (age >= 18) {
			this.age = age;
		} 
		else {
			JOptionPane.showMessageDialog(null, "you should be 18 or older then 18");
			GUI.wagetxt.setText(null);
			this.age = age;
		}
	}

	public int getID() {
		return UserID;
	}

	public void setID() {
		this.UserID = ++lastUserID;
	}

}