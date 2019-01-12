package com.github.appreciated.card.content;

import com.github.appreciated.card.label.PrimaryLabel;
import com.github.appreciated.card.label.SecondaryLabel;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ItemBody extends VerticalLayout implements HasComponents {
    public ItemBody(Component first, Component second) {
        this();
    }

    public ItemBody(String title, String description) {
        this();
        add(new PrimaryLabel(title), new SecondaryLabel(description));
    }

    public ItemBody() {
        setSpacing(false);
        setPadding(false);
        setMargin(false);
    }
}
