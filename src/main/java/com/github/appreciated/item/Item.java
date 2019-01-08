package com.github.appreciated.item;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Item extends HorizontalLayout {

    public Item() {

    }

    public Item(Component... component) {
        this();
        add(component);
    }

    public Item(String text) {
        this();
        getElement().setText(text);
    }

    public Item(String title, String description) {
        this(new ItemBody(title, description));
    }

}
