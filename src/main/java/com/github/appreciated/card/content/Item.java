package com.github.appreciated.card.content;

import com.github.appreciated.card.label.PrimaryLabel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


public class Item extends HorizontalLayout {

    public Item() {
        setMargin(false);
        setPadding(false);
    }

    public Item(Component... component) {
        this();
        add(component);
    }

    public Item(String text) {
        this(new PrimaryLabel(text));
    }

    public Item(String title, String description) {
        this(new ItemBody(title, description));
    }

}
