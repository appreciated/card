package com.github.appreciated;

import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.templatemodel.TemplateModel;

public abstract class AbstractCard extends PolymerTemplate<TemplateModel> implements HasComponents, FlexComponent, ClickNotifier {
    private final Element contentDiv;
    private VerticalLayout contentHolder;
    @Id("card-content")
    private Div content;
    private Component headerComponent;
    private String header;

    public AbstractCard() {
        this(null, null);
    }

    public AbstractCard(Component... components) {
        contentDiv = ElementFactory.createDiv();
        getElement().appendChild(contentDiv);
        contentHolder = new VerticalLayout();
        contentHolder.setPadding(false);
        contentHolder.setMargin(false);
        contentDiv.appendChild(contentHolder.getElement());
        add(components);
    }

    /**
     *
     */
    public int getElevation() {
        return Integer.parseInt(getElement().getAttribute("elevation"));
    }

    /**
     * @param elevation
     */
    public void setElevation(int elevation) {
        if (elevation < 5 && elevation >= 0)
            content.getElement().setAttribute("elevation", String.valueOf(elevation));
    }

    @Override
    public void add(Component... components) {
        contentHolder.add(components);
    }


    public VerticalLayout getContent() {
        return contentHolder;
    }

}
