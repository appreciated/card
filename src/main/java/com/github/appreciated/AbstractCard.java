package com.github.appreciated;

import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.Objects;

public abstract class AbstractCard extends PolymerTemplate<TemplateModel> implements HasComponents, FlexComponent, ClickNotifier {
    private final Element contentDiv;
    private VerticalLayout contentHolder;
    private HorizontalLayout actionHolder;
    private VerticalLayout titleHolder;
    @Id("card-content")
    private Div content;
    private Component headerComponent;
    private String header;

    public AbstractCard() {
        this(null, null);
    }

    public AbstractCard(Component content) {
        this(content, null);
    }

    public AbstractCard(Component content, Component... actions) {
        contentDiv = ElementFactory.createDiv();
        getElement().appendChild(contentDiv);
        add(content);
        contentHolder = new VerticalLayout(titleHolder);
        contentHolder.setPadding(false);
        contentHolder.setMargin(false);
        contentDiv.appendChild(contentHolder.getElement());
        if (actions != null) {
            addAction(actions);
        }
    }

    public String getImage() {
        return getElement().getAttribute("image");
    }

    public void setImage(Image image) {
        setHeaderComponent(image);
    }

    public String getAlt() {
        return getElement().getAttribute("alt");
    }

    public void setAlt(String alt) {
        getElement().setAttribute("alt", alt);
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        setHeaderComponent(new Label(header));
    }

    public Component getHeaderComponent() {
        return headerComponent;
    }

    public void setHeaderComponent(Component component) {
        if (this.headerComponent != null) {
            titleHolder.getElement().removeChild(this.headerComponent.getElement());
        }
        this.headerComponent = component;
        titleHolder.getElement().insertChild(0, headerComponent.getElement());
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
        if (titleHolder == null) {
            titleHolder = new VerticalLayout();
            titleHolder.setPadding(true);
        }
        if (content != null)
            titleHolder.add(components);
    }

    public void addAction(Component... components) {
        Objects.requireNonNull(components, "Components should not be null");
        if (components.length > 0 && actionHolder == null) {
            actionHolder = new HorizontalLayout();
            contentDiv.appendChild(actionHolder.getElement());
            actionHolder.getElement().getStyle()
                    .set("padding", "0 var(--lumo-space-m) var(--lumo-space-s) var(--lumo-space-m)");
        }
        if (components.length > 0) {
            actionHolder.add(components);
        }
    }

    public VerticalLayout getContent() {
        return titleHolder;
    }

    public HorizontalLayout getActions() {
        return actionHolder;
    }
}
