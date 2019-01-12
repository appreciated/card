package com.github.appreciated.item;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class IconItem extends HorizontalLayout {
    public IconItem(Component icon, Component component) {
        add(icon, component);
        setAlignItems(Alignment.CENTER);
        init();
    }

    public IconItem(Icon icon, Component component) {
        this((Component) icon, component);
        init();
    }

    public IconItem(Icon icon, String title) {
        this(icon, new Label(title));
        init();
    }

    public IconItem(Icon icon, String title, String description) {
        this(icon, new ItemBody(title, description));
        init();
    }

    public IconItem(Image image, Component component) {
        this((Component) image, component);
        init();
    }

    public IconItem(Image image, String title) {
        this(image, new Label(title));
        init();
    }

    public IconItem(Image image, String title, String description) {
        this(image, new ItemBody(title, description));
        init();
    }

    private void init() {
        getElement().getStyle().set("padding", "0 var(--lumo-space-m) var(--lumo-space-s) var(--lumo-space-m)");
    }

}