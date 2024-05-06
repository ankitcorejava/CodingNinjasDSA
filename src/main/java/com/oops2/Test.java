package com.oops2;

import java.util.*;
import java.io.*;

// Create the classes here
class GrandFather {

	String grandFatherName;

	GrandFather(String grandFatherName) {

		this.grandFatherName = grandFatherName;
	}
}

class Father extends GrandFather {

	String fatherName;
	Father(String grandFatherName,String fatherName) {
		super(grandFatherName);	
		this.grandFatherName = grandFatherName;
		this.fatherName = fatherName;
	}

}

class Son extends Father {

	String sonName;

	Son(String sonName, String fatherName, String grandFatherName) {
		super(grandFatherName,fatherName);	
		this.grandFatherName = grandFatherName;
		this.fatherName = fatherName;
		this.sonName = sonName;
	}

	public void printName() {
		System.out.println("sonname: " + this.sonName);
		System.out.println("fathername: " + this.fatherName);
		System.out.println("grandfather: " + this.grandFatherName);
	}
}

public class Test {

	public static void main(String args[]) {

		// Write your code here
		Son son = new Son("Saurabh", "Ramesh", "Suresh");
		son.printName();
	}
}
