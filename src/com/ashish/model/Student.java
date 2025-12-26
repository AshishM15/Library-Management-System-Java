package com.ashish.model;

public class Student {
	private int studentId;
	private String name;
	private String branch;
	//  No-argument constructor
	public Student() {
	    }
	//  Parameterized constructor
	public Student(int studentId, String name, String branch) {
		this.studentId = studentId;
		this.name = name;
		this.branch = branch;
		}
	// Getters and Setter
	public int getStudentId() {
		return studentId;
		}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
		}
	public String getName() {
		return name;
		}

	public void setName(String name) {
		this.name = name;
		}

	    public String getBranch() {
	        return branch;
	    }
	    public void setBranch(String branch) {
	    	this.branch = branch;
	    	}
	    // toString() method
	    @Override
	    public String toString() {
	    	return "Student [ID=" + studentId + ", Name=" + name + ", Branch=" + branch + "]";
	    }
	}


