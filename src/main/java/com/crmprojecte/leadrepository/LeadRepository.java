package com.crmprojecte.leadrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmprojecte.entity.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
