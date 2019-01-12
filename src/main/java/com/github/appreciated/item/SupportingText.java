package com.github.appreciated.item;


import com.vaadin.flow.component.html.Label;

public class SupportingText extends Label {
    public SupportingText() {
        init();
    }

    public SupportingText(String text) {
        super(text);
        init();
    }

    private void init() {
        getElement().getStyle().set("padding", "0 var(--lumo-space-m) var(--lumo-space-s) var(--lumo-space-m)");
    }
}
