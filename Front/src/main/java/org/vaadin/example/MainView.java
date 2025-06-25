package org.vaadin.example;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    private final TurismoClient turismoClient;
    private final ComunidadClient comunidadClient;

    private final Grid<TurismoComunidad> gridGeneral = new Grid<>(TurismoComunidad.class);
    private final DatePicker datePicker = new DatePicker("Filtrar por mes");
    private final Button btnNuevo = new Button("Nuevo");

    private final Grid<TurismoComunidad> gridAgrupado = new Grid<>(TurismoComunidad.class);
    private final Select<String> selectComunidad = new Select<>();

    public MainView(TurismoClient tc, ComunidadClient cc) {
        this.turismoClient = tc;
        this.comunidadClient = cc;

        Tab tab1 = new Tab("Datos Generales");
        Tab tab2 = new Tab("Por Comunidad");
        Tabs tabs = new Tabs(tab1, tab2);
        Div page1 = new Div(buildGeneralLayout());
        Div page2 = new Div(buildAgrupadoLayout());
        page2.setVisible(false);

        tabs.addSelectedChangeListener(e -> {
            page1.setVisible(e.getSelectedTab()==tab1);
            page2.setVisible(e.getSelectedTab()==tab2);
        });

        add(tabs, page1, page2);
        setSizeFull();
        refreshGeneral();
        refreshSelect();
    }

    private VerticalLayout buildGeneralLayout() {
        VerticalLayout layout = new VerticalLayout(datePicker, btnNuevo, gridGeneral);
        // configuración idéntica al ejemplo anterior...
        return layout;
    }

    private void refreshGeneral() {
        // igual al ejemplo anterior...
    }

    private void openEditor(TurismoComunidad t, boolean isNew) {
        // igual al ejemplo anterior...
    }

    private VerticalLayout buildAgrupadoLayout() {
        VerticalLayout layout = new VerticalLayout(selectComunidad, gridAgrupado);
        // igual al ejemplo anterior...
        return layout;
    }

    private void refreshSelect() {
        // igual al ejemplo anterior...
    }
}
