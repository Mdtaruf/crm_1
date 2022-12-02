package com.crmprojecte.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crmprojecte.entity.Billing;
import com.crmprojecte.entity.Contacts;
import com.crmprojecte.service.BillingService;
import com.crmprojecte.service.ContactService;

@Controller
public class BillingController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private BillingService billingService;
	
  @RequestMapping("/billingForm")
	public String viewBillingForm(@RequestParam("contactId") long id,Model model) {
	  Contacts contact=contactService.findContactById(id);
	  model.addAttribute("contact", contact);
		return "create_bill";
	}
  
  @RequestMapping("/generateBill")
  public String generateBill(@ModelAttribute Billing billing) {
	  billingService.generateInvoice(billing);
     	return "create_bill";
  }
}
