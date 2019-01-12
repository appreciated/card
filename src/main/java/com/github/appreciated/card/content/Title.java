package com.github.appreciated.card.content;

import com.vaadin.flow.component.html.Label;

public class Title extends Label {
    public Title() {
        init();
    }

    public Title(String text) {
        super(text);
        init();
    }

    private void init() {
        getElement().getStyle().set("padding", "0 var(--lumo-space-m) var(--lumo-space-s) var(--lumo-space-m)");
    }
}
