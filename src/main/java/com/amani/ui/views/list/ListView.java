package com.amani.ui.views.list;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amani.backend.entity.Company;
import com.amani.backend.entity.Contact;
import com.amani.backend.service.CompanyService;
import com.amani.backend.service.ContactService;
import com.amani.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Component
@Scope("prototype")
@Route(value = "List", layout = MainLayout.class)
@PageTitle("Contacts | Vaadin")
public class ListView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	ContactService contactService;
	// Defines a new field grid and instantiates it to a Grid of type Contact
	Grid<Contact> grid = new Grid<>(Contact.class);
	TextField filterText = new TextField();
	ContactForm form;

	public ListView(ContactService contactService, CompanyService companyService) {
		this.contactService = contactService; // Saves ContactService in a field, so you have easy access to it later
		addClassName("list-view"); // Gives the component a CSS class name to help with styling.
		setSizeFull(); // Calls setSizeFull() to make ListView take up the full size of the browser
						// window.

		configureGrid(); // Splits the grid configuration into a separate method.

		form = new ContactForm(companyService.findAll());
		form.addListener(ContactForm.SaveEvent.class, this::saveContact);
		form.addListener(ContactForm.DeleteEvent.class, this::deleteContact);
		form.addListener(ContactForm.CloseEvent.class, e -> closeEditor());

		Div content = new Div(grid, form); //
		content.addClassName("content");
		content.setSizeFull();

		add(getToolBar(), content); //
		updateList(); // Creates a new method, updateList(), that fetches all contacts from the
						// service, and passes them to the grid.
		closeEditor();
	}

	private void saveContact(ContactForm.SaveEvent event) {
		contactService.save(event.getContact());
		updateList();
		closeEditor();
	}

	private void deleteContact(ContactForm.DeleteEvent event) {
		contactService.delete(event.getContact());
		updateList();
		closeEditor();
	}

	private void closeEditor() {
		form.setContact(null);
		form.setVisible(false);
		removeClassName("editing");

	}

	private HorizontalLayout getToolBar() {
		filterText.setPlaceholder("Filter by name...");
		filterText.setClearButtonVisible(true);
		filterText.setValueChangeMode(ValueChangeMode.LAZY);
		filterText.addValueChangeListener(e -> updateList());

		Button addContactButton = new Button("Add contact");
		addContactButton.addClickListener(click -> addContact()); //

		HorizontalLayout toolbar = new HorizontalLayout(filterText, addContactButton); //
		toolbar.addClassName("toolbar");
		return toolbar;

	}

	private void addContact() {
		grid.asSingleSelect().clear(); //
		editContact(new Contact());
	}

	private void configureGrid() {
		grid.addClassName("contact-grid");
		grid.setSizeFull();

		grid.removeColumnByKey("company"); // Removes the default column definition with the removeColumnByKey method

		// Defines the properties of a Contact to shown using the grid.setColumns(..)
		// method
		grid.setColumns("firstName", "lastName", "email", "status");
		// add a custom column.
		grid.addColumn(contact -> {
			// gets a contact parameter, and returns how it should be shown in the grid. In
			// this case, we show the company name, or a dash if it’s empty.
			Company company = contact.getCompany();
			return company == null ? "-" : company.getName();
		}).setHeader("Company"); // defines the column header for the custom column

		// Automatic width needs to be turned on for each column separately. The easiest
		// way to do it is to call grid.getColumns() and then use forEach to loop over
		// all of them.
		grid.getColumns().forEach(col -> col.setAutoWidth(true));

		grid.asSingleSelect().addValueChangeListener(event -> editContact(event.getValue()));
	}

	public void editContact(Contact contact) {
		if (contact == null) {
			closeEditor();
		} else {
			form.setContact(contact);
			form.setVisible(true);
			addClassName("editing");
		}
	}

	private void updateList() {
		grid.setItems(contactService.findAll(filterText.getValue()));
	}

}
