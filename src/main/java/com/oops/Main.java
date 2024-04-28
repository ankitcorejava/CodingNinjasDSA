package com.oops;

class Public {

	String name;
	private int weight;
}

class Student extends Public {
	private int roll_number;
	String school_name;
}

public class Main{
	
	public static void main(String[] args) {
		Student student = new Student();
		//student.name;
		//student.school_name;
		
	}
}

