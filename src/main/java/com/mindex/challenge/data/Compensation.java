package com.mindex.challenge.data;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Compensation {
	
    private String employeeId;
    private double salary;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="MM-dd-yyyy")
    private Date effectiveDate;
    
    public Compensation() {
    }

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

}
