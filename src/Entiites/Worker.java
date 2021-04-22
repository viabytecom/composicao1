package Entiites;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Entiites_enum.WorkLevel;

public class Worker {

	private String name;
	private WorkLevel level;
	private double basedSalary;
	
	private Departament department;
	private List<HourContract>contracts =new ArrayList();
	
	public Worker() {
		
	}

	
	public Worker(String name, WorkLevel level, double basedSalary, Departament department) {
		
		this.name = name;
		this.level = level;
		this.basedSalary = basedSalary;
		this.department = department;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public WorkLevel getLevel() {
		return level;
	}


	public void setLevel(WorkLevel level) {
		this.level = level;
	}


	public double getBasedSalary() {
		return basedSalary;
	}


	public void setBasedSalary(double basedSalary) {
		this.basedSalary = basedSalary;
	}


	public Departament getDepartment() {
		return department;
	}


	public void setDepartment(Departament department) {
		this.department = department;
	}


	public List<HourContract> getContracts() {
		return contracts;
	}


	public void addContract(HourContract contract) {
		contracts.add(contract);
		
	}
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
		
	}
	public double income (int year, int month) {
		double sum = basedSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c: contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1+cal.get(Calendar.MONTH);		
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
}
	
 