package com.crmprojecte.cotroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crmprojecte.entity.Contacts;
import com.crmprojecte.entity.Lead;
import com.crmprojecte.service.ContactService;
import com.crmprojecte.service.LeadService;

@Controller
public class LeadController {
	@Autowired
	private LeadService leadService;
	@Autowired
	private ContactService contactService;
	
	//htpp://localhost:8080/start
	@RequestMapping(value = "/start",method=RequestMethod.GET)
	public String started() {
		return "creat_lead";
	}
	@RequestMapping(value ="/save", method=RequestMethod.POST)
	public String saveOneLead(@ModelAttribute("l") Lead lead, Model model) {
		leadService.saveLeadInformation(lead);
		model.addAttribute("lead", lead);
		model.addAttribute("msg", "lead is saved!!");
		return "lead_info";
	}
	
	@RequestMapping("/listleads")
	public String listLead(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/leadInfo")
	public String leadInfo(@RequestParam("id") long id, Model model) {
		Lead lead=leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	@RequestMapping("/convertLead")
	public String convertLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.findLeadById(id);
		Contacts contact= new Contacts();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveContactInformation(contact);
		
		leadService.deleteOneLead(id);
		
		List<Contacts> contacts=contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contacts";
		
	}

}
