package com.github.appreciated.card.label;

import com.vaadin.flow.component.html.Label;

public class TitleLabelComponent extends Label implements WhiteSpaceLabel {
    public TitleLabelComponent() {
        init();
    }

    public TitleLabelComponent(String text) {
        super(text);
        init();
    }

    private void init() {
        getStyle().set("font-size", "var(--lumo-font-size-xl)")
                .set("text-overflow", "ellipsis")
                .set("overflow", "hidden")
                .set("font-weight", "500");
        setWidth("100%");
    }


}
