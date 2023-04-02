package com.mindex.challenge;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.Compensation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import static org.junit.Assert.assertNotNull;

import java.text.Format;
import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataBootstrapTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private CompensationRepository compRepository;

    @Test
    public void test_Compensation() {
        Compensation comp = compRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(comp);
        assertTrue(Double.compare(200000.0d, comp.getSalary()) == 0);
        Format format = new SimpleDateFormat("MM-dd-yyyy");
        assertEquals("01-01-2020", 
        		format.format(comp.getEffectiveDate()));
    }
    
    @Test
    public void test_Employee() {
        Employee employee = employeeRepository.findByEmployeeId("16a596ae-edd3-4847-99fe-c4518e82c86f");
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Lennon", employee.getLastName());
        assertEquals("Development Manager", employee.getPosition());
        assertEquals("Engineering", employee.getDepartment());
    }
}