package com.amani.ui.views.research;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.amani.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Component
@Scope("prototype")
@Route(value = "Research", layout = MainLayout.class)
@PageTitle("Recherche | Vaadin")
public class ResearchView extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	FormLayout layout = new FormLayout();
	FormLayout layout1 = new FormLayout();
	FormLayout layout2 = new FormLayout();
	FormLayout layout3 = new FormLayout();
	FormLayout layout4 = new FormLayout();
	FormLayout layout5 = new FormLayout();

	Label facture = new Label("Facture");
	Label plage = new Label("Plage");
	Label type = new Label("Type");
	Label periode = new Label("Période");
	Label client = new Label("Client");
	Label montant = new Label("Montant TTC");
	Label exonere = new Label("Exonéré ?");
	Label profil = new Label("Profil");
	Label article = new Label("Article");
	Label Recouvrement = new Label("Recouvrement");
	Label free = new Label(" ");
	Label free1 = new Label(" ");
	Label free2 = new Label(" ");

	VerticalLayout v1 = new VerticalLayout();
	VerticalLayout v2 = new VerticalLayout();
	VerticalLayout v3 = new VerticalLayout();

	RadioButtonGroup<String> typ = new RadioButtonGroup<>();
	RadioButtonGroup<String> exo = new RadioButtonGroup<>();

	Checkbox seul = new Checkbox("Seul");
	Checkbox dernier = new Checkbox("Dernier");
	Checkbox afficher = new Checkbox("Afficher Nom Client");

	TextField num = new TextField("Numéro");
	List<String> years = new LinkedList<>();
	{
		for (int i = 2020; i > 1800; i--) {
			years.add(String.valueOf(i));
		}
		years.add("Toutes");
	}

	ComboBox<String> year = new ComboBox<>("Année ");
	ComboBox<String> profile = new ComboBox<>("Profil ");
	ComboBox<String> articl = new ComboBox<>("Article ");
	ComboBox<String> paye = new ComboBox<>("Payée");
	ComboBox<String> relance = new ComboBox<>("Relance");
	ComboBox<String> salle = new ComboBox<>("Salle");

	DatePicker start2 = new DatePicker("Du");
	LocalDate now = LocalDate.now();
	DatePicker finish2 = new DatePicker("Au");

	TextField start1 = new TextField("Du");
	TextField finish1 = new TextField("Au");
	TextField clientT = new TextField("Client");
	TextField douane = new TextField("Douane");
	TextField compte = new TextField("Compte");
	TextField start3 = new TextField("De");
	TextField finish3 = new TextField("A");

	Button recherche = new Button("Recherche");

	public ResearchView() {
		layout.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		layout1.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		layout2.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		layout3.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		layout4.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		layout5.setResponsiveSteps(new ResponsiveStep("25em", 1), new ResponsiveStep("32em", 2),
				new ResponsiveStep("40em", 3));

		year.setItems(years);
		year.setValue("Toutes");

		profile.setItems("Tous");

		articl.setItems("- Choisir article");
		salle.setItems("- Choisir salle Publique");

		typ.setItems("Emission", "Exploitation");
		exo.setItems("Oui", "Non", "Indifférent");

		v1.add(paye, relance);
		v2.add(clientT, douane, salle);
		v3.add(compte, afficher);

		// v1.addClassName("verticle");
		// v2.addClassName("verticle");
		// v3.addClassName("verticle");

		start2.setValue(now);
		finish2.setValue(now);

		layout.add(facture, num, year, plage, start1, finish1);
		layout.addClassName("verticle");

		layout1.add(periode, start2, finish2, type, typ);
		layout1.add(typ, 2);
		layout1.addClassName("verticle");

		layout2.add(client, v2, v3);
		layout2.addClassName("verticle");

		layout3.add(montant, start3, finish3, exonere, exo);
		layout3.add(exo, 2);
		layout3.add(profil, profile);
		layout3.add(profile, 2);
		layout3.add(article, articl, seul);
		layout3.addClassName("verticle");

		layout4.add(Recouvrement, paye);
		layout4.add(paye, 2);
		layout4.add(free, relance, dernier);
		layout4.addClassName("verticle");

		layout5.add(free1, recherche, free2);

		add(layout, layout1, layout2, layout3, layout4, layout5);
	}

}
