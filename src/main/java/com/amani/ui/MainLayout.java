package com.amani.ui;


import com.amani.ui.views.dashboard.DashboardView;
import com.amani.ui.views.list.ListView;
import com.amani.ui.views.research.ResearchView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.PWA;

@CssImport("./styles/shared-styles.css")

@PWA( 
	    name = "Vaadin Login",
	    shortName = "Login",
	    offlineResources = { // 
	            "./styles/offline.css",
	            "./images/offline.jpg"},
	    enableInstallPrompt = false) 
@Route("mainpage")
public class MainLayout extends AppLayout { 
    
	private static final long serialVersionUID = 1L;

	public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Vaadin application");
        logo.addClassName("logo");
        Anchor logout = new Anchor("/logout", "Log out");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo,logout); 
        header.expand(logo);

        header.setDefaultVerticalComponentAlignment(
             FlexComponent.Alignment.CENTER);  
        header.setWidth("100%");
        header.addClassName("header");


        addToNavbar(header);  

    }

    private void createDrawer() {
        RouterLink listLink = new RouterLink("List", ListView.class); 
        listLink.setHighlightCondition(HighlightConditions.sameLocation());

       
        RouterLink research = new RouterLink("Recherche", ResearchView.class); 
        research.setHighlightCondition(HighlightConditions.sameLocation());
        
        addToDrawer(new VerticalLayout(listLink,research,new RouterLink("Dashboard", DashboardView.class))); 
    }
}