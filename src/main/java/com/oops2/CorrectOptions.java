package com.oops2;

class Vehicle1 {
    protected String name;
}
 

class Car1 {
    void props() {
        Vehicle v = new Vehicle();
        v.name = "Vehicle 1st";      
    }
}

public class CorrectOptions{
	
	public static void main(String[] args) {
		Car1 car = new Car1();
		car.props();
		
	}
}


