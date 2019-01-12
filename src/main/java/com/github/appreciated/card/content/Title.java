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
        getStyle().set("font-size", "var(--lumo-font-size-xl)");
    }
}
