package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.EmployeeReportingStructure;
import com.mindex.challenge.service.EmployeeReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeReportServiceImpl implements EmployeeReportService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeReportServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeReportingStructure getEmployeeReportingStructure(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }
        
        EmployeeReportingStructure report = new EmployeeReportingStructure();
        report.setEmployeeId(id);
        report.setNumberOfReports(getAllReports(employee.getDirectReports()));
        
        return report;
    }
    
    private int getAllReports(List<Employee> empList)
    {
    	if(empList == null || empList.size() == 0)
    		return 0;
    	
    	List<Employee> innerEmpList = new ArrayList<Employee>();
    	
    	for(Employee e : empList)
    	{
    		Employee employee = employeeRepository.findByEmployeeId(e.getEmployeeId());

            if (employee == null) {
                throw new RuntimeException("Invalid employeeId: " + e.getEmployeeId());
            }
            
            if(employee.getDirectReports() != null && employee.getDirectReports().size() > 0)
            	innerEmpList.addAll(employee.getDirectReports());
    	}
    	
    	return empList.size() + getAllReports(innerEmpList);
    }
}
