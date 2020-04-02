package com.github.appreciated.card.label;

import com.vaadin.flow.component.html.Span;

public class PrimaryLabelComponent extends Span implements WhiteSpaceLabel {
    public PrimaryLabelComponent() {
        init();
    }

    public PrimaryLabelComponent(String text) {
        super(text);
        init();
    }

    private void init() {
        getStyle()
                .set("font-size", "var(--lumo-font-size-l)")
                .set("text-overflow", "ellipsis")
                .set("overflow", "hidden")
                .set("font-weight", "500");
        setWidth("100%");
    }
}
