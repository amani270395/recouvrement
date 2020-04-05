package com.amani.security;

import org.springframework.stereotype.Component;

import com.amani.ui.views.login.LoginView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;

@Component // The @Component annotation registers the listener. Vaadin will pick it up on startup.
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

	private static final long serialVersionUID = 1L;

	@Override
	public void serviceInit(ServiceInitEvent event) {
		event.getSource().addUIInitListener(uiEvent -> { 
			//In serviceInit, we listen for the initialization of the UI 
			//(the internal root component in Vaadin)
			// and then add a listener before every view transition. 
			final UI ui = uiEvent.getUI();
			ui.addBeforeEnterListener(this::authenticateNavigation);
		});
	}

	private void authenticateNavigation(BeforeEnterEvent event) {
		if (!LoginView.class.equals(event.getNavigationTarget())
		    && !SecurityUtils.isUserLoggedIn()) { //In authenticateNavigation, we reroute all requests to the login, if the user is not logged in 
			event.rerouteTo(LoginView.class);
		}
	}
}
