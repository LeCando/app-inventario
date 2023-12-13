package com.example.application.views.nuevoinstrumento;

import com.example.Utils.Util;
import com.example.application.views.MainLayout;
import com.example.models.Producto;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import java.util.ArrayList;
import java.util.List;

@PageTitle("Nuevo Instrumento")
@Route(value = "nuevo-instrumento", layout = MainLayout.class)
@Uses(Icon.class)
public class NuevoInstrumentoView extends Composite<VerticalLayout> {

    public NuevoInstrumentoView() {
        ComboBox comboBox = new ComboBox();
        HorizontalLayout layoutRow = new HorizontalLayout();
        TextField textField = new TextField();
        TextField textField2 = new TextField();
        HorizontalLayout layoutRow2 = new HorizontalLayout();
        TextField textField3 = new TextField();
        TextField textField4 = new TextField();
        HorizontalLayout layoutRow3 = new HorizontalLayout();
        TextField textField5 = new TextField();
        TextField textField6 = new TextField();
        ComboBox comboBox2 = new ComboBox();
        HorizontalLayout layoutRow4 = new HorizontalLayout();
        Button guardar = new Button();
        Button buttonSecondary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        comboBox.setLabel("Tipo de Instrumento");
        comboBox.setWidth("min-content");
        setComboBoxSampleData(comboBox);
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        textField.setLabel("Nombre");
        textField.setWidth("380px");
        textField2.setLabel("Codigo");
        textField2.setWidth("380px");
        layoutRow2.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow2);
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutRow2.setWidth("100%");
        layoutRow2.getStyle().set("flex-grow", "1");
        textField3.setLabel("Precio");
        textField3.setWidth("380px");
        textField4.setLabel("Stock");
        textField4.setWidth("380px");
        layoutRow3.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow3);
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutRow3.setWidth("100%");
        layoutRow3.getStyle().set("flex-grow", "1");
        textField5.setLabel("Color");
        textField5.setWidth("380px");
        textField6.setLabel("Marca");
        textField6.setWidth("380px");
        comboBox2.setLabel("Calidad");
        comboBox2.setWidth("150px");
        setComboBoxSampleData(comboBox2);
        layoutRow4.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.setWidth("100%");
        layoutRow4.getStyle().set("flex-grow", "1");
        guardar.setText("Guardar");
        guardar.setWidth("min-content");
        guardar.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        guardar.addClickListener(event -> {
            // Obtener los valores de los campos y guardar en la lista de productos
            //String tipo = (String) comboBox.getValue();
            String nombre = textField.getValue();
            String codigo = textField2.getValue();
            double precio = Float.parseFloat(textField3.getValue());
            Integer stock = Integer.valueOf(textField4.getValue());
            String color = textField5.getValue();
            String marca = textField6.getValue();
            //String calidad = (String) comboBox2.getValue();

            // Crear una nueva instancia de Producto

            Producto producto1 = new Producto();

            // Validar que los campos no estén vacíos antes de guardar
            //producto1.setTipo(tipo);
            producto1.setNombre(nombre);
            producto1.setCodigo(codigo);
            producto1.setPrecio(precio);
            producto1.setStock(stock);
            producto1.setColor(color);
            producto1.setMarca(marca);
            //producto1.setCalidad(calidad);

            Util.listaProducto.add(producto1);

            // Navegar a la vista de productos después de guardar
            getUI().ifPresent(ui -> ui.navigate("instrumento"));
        });

        buttonSecondary.setText("Cancelar");
        buttonSecondary.setWidth("min-content");
        getContent().add(comboBox);
        getContent().add(layoutRow);
        layoutRow.add(textField);
        layoutRow.add(textField2);
        getContent().add(layoutRow2);
        layoutRow2.add(textField3);
        layoutRow2.add(textField4);
        getContent().add(layoutRow3);
        layoutRow3.add(textField5);
        layoutRow3.add(textField6);
        getContent().add(comboBox2);
        getContent().add(layoutRow4);
        layoutRow4.add(guardar);
        layoutRow4.add(buttonSecondary);
    }

    record SampleItem(String value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("viento", "Viento", null));
        sampleItems.add(new SampleItem("cuerda", "Cuerda", null));
        sampleItems.add(new SampleItem("percusion", "Percusion", Boolean.TRUE));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

    private void setComboBox2SampleData(ComboBox comboBox2) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem("alta", "Alta", null));
        sampleItems.add(new SampleItem("media", "Media", null));
        sampleItems.add(new SampleItem("baja", "Baja", Boolean.TRUE));
        comboBox2.setItems(sampleItems);
        comboBox2.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }
}
