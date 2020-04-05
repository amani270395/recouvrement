package com.amani.ui.add;


import com.amani.backend.entity.User;
import com.amani.ui.views.list.ContactForm;
import com.amani.ui.views.list.ContactForm.CloseEvent;
import com.amani.ui.views.list.ContactForm.ContactFormEvent;
import com.amani.ui.views.list.ContactForm.DeleteEvent;
import com.amani.ui.views.list.ContactForm.SaveEvent;
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
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.shared.Registration;
public class UserForm extends FormLayout {

	private static final long serialVersionUID = 1L;
	TextField username = new TextField("First name");
	EmailField email = new EmailField("Email");
	ComboBox<String> role = new ComboBox<>("Role");
	
	PasswordField password = new PasswordField("Password");
	PasswordField confirmPassword = new PasswordField("Confirm Password");
	
	Button save = new Button("Save"); //
	Button delete = new Button("Delete");
	Button close = new Button("Cancel");
	
	Binder<User> binder = new BeanValidationBinder<>(User.class);

	public UserForm() {
		
		addClassName("user-form");
		binder.bindInstanceFields(this);
		role.setItems("USER","ADMIN","MANAGER");
		add(username, email,role,password,confirmPassword, createButtonsLayout());
	}
	
	public void setContact(User user) {
		binder.setBean(user);
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
		
		return new HorizontalLayout(save, delete, close);
		
	}
	
	private void validateAndSave() {
		if (binder.isValid()) { //
			fireEvent(new SaveEvent(this, binder.getBean()));
		}
	}
	
	public static abstract class UserFormEvent extends ComponentEvent<UserForm> {

		private static final long serialVersionUID = 1L;
		private User user;

		protected UserFormEvent(UserForm source, User user) { //
			super(source, false);
			this.user = user;
		}

		public User getUser() {
			return user;
		}
	}

	public static class SaveEvent extends UserFormEvent {

		private static final long serialVersionUID = 1L;

		SaveEvent(UserForm source, User user) {
			super(source, user);
		}
	}

	public static class DeleteEvent extends UserFormEvent {

		private static final long serialVersionUID = 1L;

		DeleteEvent(UserForm source, User user) {
			super(source, user);
		}

	}

	public static class CloseEvent extends UserFormEvent {

		private static final long serialVersionUID = 1L;

		CloseEvent(UserForm source) {
			super(source, null);
		}
	}

	public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType,
			ComponentEventListener<T> listener) { //
		return getEventBus().addListener(eventType, listener);
	}

	
}
