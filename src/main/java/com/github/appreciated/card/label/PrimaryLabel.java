package com.github.appreciated.card.label;

import com.github.appreciated.card.content.HorizontalCardComponentContainer;
import com.vaadin.flow.component.Component;

public class PrimaryLabel extends HorizontalCardComponentContainer implements WhiteSpaceLabel {
    public PrimaryLabel(Component component) {
        super(component);
    }

    public PrimaryLabel(String text) {
        super(new PrimaryLabel(text));
    }
}
