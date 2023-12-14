package com.example.application.views.nuevoinstrumento;

import com.example.Utils.Util;
import com.example.application.views.MainLayout;
import com.example.models.Producto;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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

        ComboBox cbTipoInstrumento = new ComboBox();
        HorizontalLayout layoutRow = new HorizontalLayout();
        Button btIr = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        cbTipoInstrumento.setLabel("Categoria");
        cbTipoInstrumento.setWidth("min-content");
        setComboBoxSampleData(cbTipoInstrumento);
        layoutRow.setWidthFull();
        getContent().setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setWidth("100%");
        layoutRow.getStyle().set("flex-grow", "1");
        btIr.setText("Ir");
        btIr.setWidth("min-content");
        btIr.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        btIr.addClickListener(e -> {

            SampleItem selectedItem = (SampleItem) cbTipoInstrumento.getValue();
            String categoria = selectedItem != null ? selectedItem.label() : "";

            Producto producto = new Producto();
            producto.setCategoria(categoria);

            int tipo = ((SampleItem)cbTipoInstrumento.getValue()).value;

            if (tipo == 1) {
                UI.getCurrent().navigate("cuerda");
            } else if (tipo == 2) {
                UI.getCurrent().navigate("percusion");
            }else if (tipo == 3){
                UI.getCurrent().navigate("viento");
            }

            Util.listaProducto.add(producto);

        });

        getContent().add(cbTipoInstrumento);
        getContent().add(layoutRow);
        layoutRow.add(btIr);
    }

    record SampleItem(int value, String label, Boolean disabled) {
    }

    private void setComboBoxSampleData(ComboBox comboBox) {
        List<SampleItem> sampleItems = new ArrayList<>();
        sampleItems.add(new SampleItem(1, "Cuerda", null));
        sampleItems.add(new SampleItem(2, "Percusion", null));
        sampleItems.add(new SampleItem(3, "Viento", null));
        comboBox.setItems(sampleItems);
        comboBox.setItemLabelGenerator(item -> ((SampleItem) item).label());
    }

}