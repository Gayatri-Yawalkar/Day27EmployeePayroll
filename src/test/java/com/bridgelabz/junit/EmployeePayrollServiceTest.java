package com.bridgelabz.junit;
//Uc6
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;
import com.bridgelabz.employeepayroll.EmployeePayrollData;
import com.bridgelabz.employeepayroll.EmployeePayrollService;
public class EmployeePayrollServiceTest {
	@Test
	public void given3Employees_whenWrittenToFile_should_MatchEmployeeEntries() {
		EmployeePayrollData[] arrayOfEmps= { new EmployeePayrollData(1,"Dharti",10000.0),
					               new EmployeePayrollData(2,"Pooja",20000.0),
					               new EmployeePayrollData(3,"Sapna",30000.0) }; 					  
		EmployeePayrollService employeePayrollService=new EmployeePayrollService(Arrays.asList(arrayOfEmps));
		employeePayrollService.writeEmployeePayrollData(EmployeePayrollService.IOService.FILE_IO);
		employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
		long entries=employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
		assertEquals(3,entries);
	}
}
