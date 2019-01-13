package com.github.appreciated.card.action;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class Actions extends Div {

    public Actions(Component... children) {
        super(children);
        setWidth("100%");
        getStyle()
                .set("padding", "var(--lumo-space-xs) calc(var(--lumo-space-s) * 1.3)")
                .set("box-sizing", "border-box");
    }

}
