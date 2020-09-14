package com.github.appreciated.card.label;

import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.HasStyle;
import com.vaadin.flow.component.html.Span;

public class TitleLabelComponent extends Span implements WhiteSpaceLabel, HasStyle, HasSize {

    public TitleLabelComponent(String text) {
        super(text);
        init();
    }

    private void init() {
        getStyle().set("font-size", "var(--lumo-font-size-xl,var(--material-h5-font-size))")
                .set("text-overflow", "ellipsis")
                .set("overflow", "hidden")
                .set("font-weight", "500");
        setWidth("100%");
    }

}
