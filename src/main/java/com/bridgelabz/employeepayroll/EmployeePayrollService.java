package com.bridgelabz.employeepayroll;
//Uc7
import java.util.List;
import java.util.Scanner;
public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO,FILE_IO,DB_IO,RESR_IO
	}
	public List<EmployeePayrollData> employeePayrollList;
	public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList) {
		this.employeePayrollList=employeePayrollList;
	}
	public void writeEmployeePayrollData(IOService ioService) {
		if(ioService.equals(IOService.CONSOLE_IO)) {
			System.out.println("\nWriting Employee Payroll to Console\n"+employeePayrollList);
		} else if(ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().writeData(employeePayrollList);
		}
	}
	public void readEmployeePayrollData(Scanner sc) {
		System.out.println("Enter Employee id");
		int id=sc.nextInt();
		System.out.println("Enter Employee Name");
		String name=sc.next();
		System.out.println("Enter Employee Salary");
		double salary=sc.nextDouble();
		employeePayrollList.add(new EmployeePayrollData(id, name, salary));
	}
	public int readEmployeePayrollData(IOService ioService) {
		List<String> empList=null;
		if(ioService.equals(IOService.FILE_IO)) {
			empList=new EmployeePayrollFileIOService().readData();
		}
		return empList.size();
	}
	public void printData(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO)) {
			new EmployeePayrollFileIOService().printdata();
		}
	}
	public long countEntries(IOService ioService) {
		if(ioService.equals(IOService.FILE_IO)) {
			return new EmployeePayrollFileIOService().countEntries();
		}
		return 0;
	}
}
