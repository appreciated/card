package com.github.appreciated.card;

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

public abstract class AbstractCard<T extends AbstractCard> extends PolymerTemplate<TemplateModel> implements HasComponents, FlexComponent, ClickNotifier {
    private final Element contentDiv;
    private VerticalLayout contentHolder;
    @Id("card-content")
    private Div content;

    public AbstractCard() {
        this(null, null);
    }

    public AbstractCard(Component... components) {
        setElevation(1);
        contentDiv = ElementFactory.createDiv();
        getElement().appendChild(contentDiv);
        contentHolder = new VerticalLayout();
        contentHolder.setPadding(false);
        contentHolder.setMargin(false);
        contentHolder.setSpacing(false);
        contentDiv.appendChild(contentHolder.getElement());
        if (components != null) {
            add(components);
        }
    }

    /**
     *
     */
    public int getElevation() {
        return Integer.parseInt(getElement().getAttribute("elevation"));
    }

    /**
     * Sets the elevation of this card. Value must be be in range from 0-5 (--lumo-box-shadow-s) -> --lumo-box-shadow-xl))
     *
     * @param elevation
     */
    public void setElevation(int elevation) {
        if (elevation < 6 && elevation >= 0)
            content.getElement().setAttribute("elevation", String.valueOf(elevation));
    }

    public T withElevation(int elevation) {
        setElevation(elevation);
        return (T) this;
    }

    @Override
    public void add(Component... components) {
        contentHolder.add(components);
    }


    public VerticalLayout getContent() {
        return contentHolder;
    }

}
