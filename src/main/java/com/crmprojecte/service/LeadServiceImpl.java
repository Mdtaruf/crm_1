package com.crmprojecte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmprojecte.entity.Lead;
import com.crmprojecte.leadrepository.LeadRepository;
@Service
public class LeadServiceImpl implements LeadService {

	@Autowired 
	private LeadRepository leadRepo;
	
	@Override
	public void saveLeadInformation(Lead lead) {
		leadRepo.save(lead);

	}

	@Override
	public List<Lead> getAllLeads() {
		List<Lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public Lead findLeadById(long id) {
		Optional<Lead> findById = leadRepo.findById(id);
		Lead lead = findById.get();
		return lead;
	}

	@Override
	public void deleteOneLead(long id) {
		leadRepo.deleteById(id);
		
	}

}
