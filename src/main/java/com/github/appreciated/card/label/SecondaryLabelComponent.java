package com.github.appreciated.card.label;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Span;

public class SecondaryLabelComponent extends Span implements WhiteSpaceLabel, HasStyle, HasSize {

    public SecondaryLabelComponent(String text) {
        super(text);
        init();
    }

    private void init() {
        getStyle()
                .set("font-size", "var(--lumo-font-size-s, var(--material-small-font-size))")
                .set("text-overflow", "ellipsis")
                .set("overflow", "hidden")
                .set("overflow", "hidden")
                .set("color", "var(--lumo-secondary-text-color, var(--material-secondary-text-color))");
        setWidth("100%");
    }

}
