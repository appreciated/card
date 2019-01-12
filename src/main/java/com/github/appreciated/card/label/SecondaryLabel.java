package com.github.appreciated.card.label;

import com.vaadin.flow.component.html.Label;

public class SecondaryLabel extends Label {
    public SecondaryLabel() {
        getStyle()
                .set("font-size", "var(--lumo-font-size-s)")
                .set("color", "var(--lumo-secondary-text-color)");
    }

    public SecondaryLabel(String text) {
        super(text);
        getStyle()
                .set("font-size", "var(--lumo-font-size-s)")
                .set("color", "var(--lumo-secondary-text-color)");
    }
}
