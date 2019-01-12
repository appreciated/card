package com.github.appreciated.item;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Item extends HorizontalLayout {

    public Item() {
        init();
    }

    public Item(Component... component) {
        this();
        add(component);
        init();
    }

    public Item(String text) {
        this();
        getElement().setText(text);
        init();
    }

    public Item(String title, String description) {
        this(new ItemBody(title, description));
        init();
    }

    private void init() {
        getElement().getStyle().set("padding", "0 var(--lumo-space-m) var(--lumo-space-s) var(--lumo-space-m)");
    }

}
