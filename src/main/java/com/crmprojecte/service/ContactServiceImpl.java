package com.crmprojecte.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.crmprojecte.entity.Contacts;
import com.crmprojecte.entity.Lead;
import com.crmprojecte.leadrepository.ContactRepository;
import com.crmprojecte.leadrepository.LeadRepository;
@Service
public class ContactServiceImpl implements ContactService {

	@Autowired 
	private ContactRepository contactRepo;
	
	@Override
	public void saveContactInformation(Contacts contact) {
		contactRepo.save(contact);

	}

	@Override
	public List<Contacts> getAllContacts() {
		List<Contacts> contacts = contactRepo.findAll();
		return contacts;
	}

	@Override
	public Contacts findContactById(long id) {
		Optional<Contacts> findById = contactRepo.findById(id);
		Contacts contacts = findById.get();
		return contacts;
	}

	

}
