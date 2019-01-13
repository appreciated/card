package com.github.appreciated.card.content;

import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.PrimaryLabelComponent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.ThemableLayout;

public class IconItem extends HorizontalCardComponentContainer {
    private Component component;

    public IconItem(Component icon, Component component) {
        this.component = component;
        add(icon, component);
        setAlignItems(Alignment.CENTER);
        icon.getElement().getStyle().set("flex-shrink", "0");
        setWidth("100%");
        if (component instanceof ThemableLayout) {
            ((ThemableLayout) component).setPadding(false);
            ((ThemableLayout) component).getElement().getStyle()
                    .set("width", "0px")
                    .set("flex-grow", "1");
        }
    }

    public IconItem(Icon icon, Component component) {
        this((Component) icon, component);
    }

    public IconItem(Icon icon, String title) {
        this(icon, new PrimaryLabelComponent(title));
    }

    public IconItem(Icon icon, String title, String description) {
        this(icon, new ItemBody(title, description));
    }

    public IconItem(Image image, Component component) {
        this((Component) image, component);
    }

    public IconItem(Image image, String title) {
        this(image, new Label(title));
    }

    public IconItem(Image image, String title, String description) {
        this(image, new ItemBody(title, description));
    }

    public IconItem withWhiteSpaceNoWrap() {
        if (component instanceof PrimaryLabel) {
            ((PrimaryLabel) component).setWhiteSpaceNoWrap();
        } else if (component instanceof ItemBody) {
            ((ItemBody) component).withWhiteSpaceNoWrap();
        }
        return this;
    }
}