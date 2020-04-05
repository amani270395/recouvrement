package com.amani.ui.add;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amani.ui.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
@Component
@Scope("prototype")
@Route(value = "Add", layout = MainLayout.class) 
@PageTitle("User | Vaadin")
public class AddUser extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	
	
	UserForm form;
	
	public AddUser() {
		
		addClassName("add-user");
		form=new UserForm();
		add(form);
	}
	
	
	

}
