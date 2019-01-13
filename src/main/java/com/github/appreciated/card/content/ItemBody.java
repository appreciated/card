package com.github.appreciated.card.content;

import com.github.appreciated.card.label.PrimaryLabelComponent;
import com.github.appreciated.card.label.SecondaryLabelComponent;
import com.vaadin.flow.component.Component;

import java.util.Objects;

public class ItemBody extends VerticalCardComponentContainer {
    private PrimaryLabelComponent primaryLabel;
    private SecondaryLabelComponent secondaryLabel;

    public ItemBody(Component first, Component second) {
        add(first, second);
        setTheme();
    }

    public ItemBody(String title, String description) {
        primaryLabel = new PrimaryLabelComponent(title);
        secondaryLabel = new SecondaryLabelComponent(description);
        add(primaryLabel, secondaryLabel);
        setTheme();
    }

    public ItemBody withWhiteSpaceNoWrap() {
        Objects.requireNonNull(primaryLabel);
        primaryLabel.setWhiteSpaceNoWrap();
        return this;
    }

    public void setTheme() {
        getElement().setAttribute("theme", "spacing-xs");
    }

}
