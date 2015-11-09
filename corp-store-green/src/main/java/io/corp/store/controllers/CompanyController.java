package io.corp.store.controllers;

import io.corp.store.domain.Company;
import io.corp.store.repositories.CompanyRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class CompanyController{
	
	    @Autowired
	    CompanyRepository repository;

	    @RequestMapping("/")
	    public String fortunes(Model model) {
	    	Iterable<Company> response = repository.findAll();
	    	model.addAttribute("companyList", response);
	    	return "index";
	         
	    }

}
