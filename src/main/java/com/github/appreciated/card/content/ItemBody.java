package com.github.appreciated.card.content;

import com.github.appreciated.card.label.PrimaryLabelComponent;
import com.github.appreciated.card.label.SecondaryLabelComponent;

public class ItemBody extends VerticalCardComponentContainer {
    private final PrimaryLabelComponent primaryLabel;
    private final SecondaryLabelComponent secondaryLabel;

    public ItemBody(String title, String description) {
        primaryLabel = new PrimaryLabelComponent(title);
        secondaryLabel = new SecondaryLabelComponent(description);
        add(primaryLabel, secondaryLabel);
        setTheme();
    }

    public ItemBody withWhiteSpaceNoWrap() {
        primaryLabel.setWhiteSpaceNoWrap();
        return this;
    }

    public void setTheme() {
        getElement().setAttribute("theme", "spacing-xs");
    }

}
