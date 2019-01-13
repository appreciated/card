package com.github.appreciated.card.label;

import com.github.appreciated.card.content.HorizontalCardComponentContainer;
import com.vaadin.flow.component.Component;

public class SecondaryLabel extends HorizontalCardComponentContainer implements WhiteSpaceLabel {
    public SecondaryLabel(Component component) {
        super(component);
    }

    public SecondaryLabel(String text) {
        super(new SecondaryLabel(text));
    }
}
