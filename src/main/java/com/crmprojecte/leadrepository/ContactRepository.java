package com.crmprojecte.leadrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crmprojecte.entity.Contacts;


public interface ContactRepository extends JpaRepository<Contacts, Long> {

}
