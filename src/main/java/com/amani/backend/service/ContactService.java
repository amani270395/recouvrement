package com.amani.backend.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;


import com.amani.backend.entity.Contact;
import com.amani.backend.repository.CompanyRepository;
import com.amani.backend.repository.ContactRepository;

@Service 
public class ContactService {
	private static final Logger LOGGER = Logger.getLogger(ContactService.class.getName());
	private ContactRepository contactRepository;
	private CompanyRepository companyRepository;

	public ContactService(ContactRepository contactRepository,
												CompanyRepository companyRepository) { 
		//The constructor takes 2 parameters: ContactRepository and CompanyRepository. Spring provides instances based on the interfaces we defined earlier.
		this.contactRepository = contactRepository;
		this.companyRepository = companyRepository;
	}

	public List<Contact> findAll() {
		return contactRepository.findAll();
	}
	
	public List<Contact> findAll(String filter) {
		if (filter == null || filter.isEmpty()) { // 
			return contactRepository.findAll();
		} else {
			return contactRepository.search(filter); // 
		}
	}

	public long count() {
		return contactRepository.count();
	}

	public void delete(Contact contact) {
		contactRepository.delete(contact);
	}

	public void save(Contact contact) {
		if (contact == null) { 
			//For now, most operations are just passed through to the repository. The only exception is the save method, which checks for null values before attempting to save.
			LOGGER.log(Level.SEVERE,
					"Contact is null. Are you sure you have connected your form to the application?");
			return;
		}
		contactRepository.save(contact);
	}
	
	
}
