package com.amani.ui.views.list;

import java.util.List;

import com.amani.backend.entity.Company;
import com.amani.backend.entity.Contact;
import com.amani.ui.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

public class ContactForm extends FormLayout { //

	private static final long serialVersionUID = 1L;
	TextField firstName = new TextField("First name"); //
	TextField lastName = new TextField("Last name");
	EmailField email = new EmailField("Email");
	ComboBox<Contact.Status> status = new ComboBox<>("Status");
	ComboBox<Company> company = new ComboBox<>("Company");

	Button save = new Button("Save"); //
	Button delete = new Button("Delete");
	Button close = new Button("Cancel");

	Binder<Contact> binder = new BeanValidationBinder<>(Contact.class);

	public ContactForm(List<Company> companies) {
		addClassName("contact-form");
		binder.bindInstanceFields(this);

		company.setItems(companies);
		company.setItemLabelGenerator(Company::getName);
		status.setItems(Contact.Status.values());

		add(firstName, lastName, email, company, status, createButtonsLayout());
	}

	public void setContact(Contact contact) {
		binder.setBean(contact);
	}

	private Component createButtonsLayout() {
		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
		close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

		save.addClickShortcut(Key.ENTER); //
		close.addClickShortcut(Key.ESCAPE);

		save.addClickListener(event -> validateAndSave()); //
		delete.addClickListener(event -> fireEvent(new DeleteEvent(this, binder.getBean()))); //
		close.addClickListener(event -> fireEvent(new CloseEvent(this)));

		binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));
		return new HorizontalLayout(save, delete, close); //
	}

	private void validateAndSave() {
		if (binder.isValid()) { //
			fireEvent(new SaveEvent(this, binder.getBean()));
		}
	}

	// Events
	public static abstract class ContactFormEvent extends ComponentEvent<ContactForm> {

		private static final long serialVersionUID = 1L;
		private Contact contact;

		protected ContactFormEvent(ContactForm source, Contact contact) { //
			super(source, false);
			this.contact = contact;
		}

		public Contact getContact() {
			return contact;
		}
	}

	public static class SaveEvent extends ContactFormEvent {

		private static final long serialVersionUID = 1L;

		SaveEvent(ContactForm source, Contact contact) {
			super(source, contact);
		}
	}

	public static class DeleteEvent extends ContactFormEvent {

		private static final long serialVersionUID = 1L;

		DeleteEvent(ContactForm source, Contact contact) {
			super(source, contact);
		}

	}

	public static class CloseEvent extends ContactFormEvent {

		private static final long serialVersionUID = 1L;

		CloseEvent(ContactForm source) {
			super(source, null);
		}
	}

	public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
			ComponentEventListener<T> listener) { //
		return getEventBus().addListener(eventType, listener);
	}

}
