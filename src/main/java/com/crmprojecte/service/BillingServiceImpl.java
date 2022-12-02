package com.crmprojecte.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crmprojecte.entity.Billing;
import com.crmprojecte.leadrepository.BillingRepository;
@Service
public class BillingServiceImpl implements BillingService {
  @Autowired
  private BillingRepository billingRepo;
	
	@Override
	public void generateInvoice(Billing billing) {
		billingRepo.save(billing);
		
	}

}
