package com.amani.ui.views.login;

import java.util.Collections;

import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route("login")  //maps the view to the root.
@PageTitle("Login | Vaadin ")

public class LoginView extends VerticalLayout implements BeforeEnterObserver {

	private static final long serialVersionUID = 1L;
	private LoginForm login = new LoginForm(); //Instantiates a LoginForm component to capture username and password

	public LoginView(){
		addClassName("login-view");
		setSizeFull();
		//makes LoginView full size and centers its content both horizontally and vertically
		setAlignItems(Alignment.CENTER); 
		setJustifyContentMode(JustifyContentMode.CENTER);

		//sets the LoginForm action to "login" to post the login form to Spring Security.
		login.setAction("login"); 

		add(new H1("Vaadin Application"), login);
	}

	@Override
	public void beforeEnter(BeforeEnterEvent event) {
		// inform the user about an authentication error
		if(!event.getLocation()  
			.getQueryParameters()
			.getParameters()
			.getOrDefault("error", Collections.emptyList())
			.isEmpty()) {
			login.setError(true);
		}
	}
}
