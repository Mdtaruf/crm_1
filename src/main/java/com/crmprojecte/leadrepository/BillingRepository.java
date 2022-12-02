package com.crmprojecte.leadrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmprojecte.entity.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long>{

}
