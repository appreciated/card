package com.github.appreciated.card.content;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ItemBody extends VerticalLayout implements HasComponents {
    public ItemBody(Component first, Component second) {
        this();
    }

    public ItemBody(String title, String description) {
        this();
        Label titleLabel = new Label(title);
        titleLabel.getStyle()
                .set("font-size", "var(--lumo-font-size-m)")
                .set("font-weight", "500");
        Label descriptionLabel = new Label(description);
        descriptionLabel.getStyle().set("font-size", "var(--lumo-font-size-s)");
        add(titleLabel, descriptionLabel);
    }

    public ItemBody() {
        setSpacing(false);
        setPadding(false);
        setMargin(false);
    }
}
