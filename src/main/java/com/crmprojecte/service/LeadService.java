package com.crmprojecte.service;

import java.util.List;

import com.crmprojecte.entity.Lead;

public interface LeadService {
   
	public void saveLeadInformation(Lead lead);
	public List<Lead> getAllLeads();
	public Lead findLeadById(long id);
	public void deleteOneLead(long id);
}
