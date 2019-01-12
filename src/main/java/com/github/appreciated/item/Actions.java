package com.github.appreciated.item;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Actions extends HorizontalLayout {

    public Actions() {
        init();
    }

    public Actions(Component... children) {
        super(children);
        init();
    }

    private void init() {
        getElement().getStyle().set("padding", "0 var(--lumo-space-m) var(--lumo-space-s) var(--lumo-space-m)");
    }

}
