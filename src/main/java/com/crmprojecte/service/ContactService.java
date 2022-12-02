package com.crmprojecte.service;

import java.util.List;

import com.crmprojecte.entity.Contacts;


public interface ContactService {
   
	public void saveContactInformation(Contacts contacts);
	public List<Contacts> getAllContacts ();
	public Contacts  findContactById(long id);
}
