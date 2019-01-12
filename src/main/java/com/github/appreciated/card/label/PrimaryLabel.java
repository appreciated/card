package com.github.appreciated.card.label;

import com.vaadin.flow.component.html.Label;

public class PrimaryLabel extends Label {
    public PrimaryLabel() {
        getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("font-weight", "500");
    }

    public PrimaryLabel(String text) {
        super(text);
        getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("font-weight", "500");
    }
}
