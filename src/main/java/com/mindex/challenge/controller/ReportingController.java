package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.EmployeeReportingStructure;
import com.mindex.challenge.service.EmployeeReportService;

@RestController
public class ReportingController {
	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);
	
    @Autowired
    private EmployeeReportService empReportService;
	
    @GetMapping("/report/{id}")
    public EmployeeReportingStructure read(@PathVariable String id) {
        LOG.debug("Received employee create request for id [{}]", id);

        return empReportService.getEmployeeReportingStructure(id);
    }
	
}
