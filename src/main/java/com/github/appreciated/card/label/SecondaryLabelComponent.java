package com.github.appreciated.card.label;

import com.vaadin.flow.component.html.Label;

public class SecondaryLabelComponent extends Label implements WhiteSpaceLabel {

    public SecondaryLabelComponent() {
        init();
    }

    public SecondaryLabelComponent(String text) {
        super(text);
        init();
    }

    private void init() {
        getStyle()
                .set("font-size", "var(--lumo-font-size-s)")
                .set("text-overflow", "ellipsis")
                .set("overflow", "hidden")
                .set("overflow", "hidden")
                .set("color", "var(--lumo-secondary-text-color)");
        setWidth("100%");
    }

}
