package com.github.appreciated.card.content;

import com.github.appreciated.card.label.TitleLabelComponent;

public class Title extends HorizontalCardComponentContainer {
    private final TitleLabelComponent label;

    public Title(String text) {
        label = new TitleLabelComponent(text);
        add(label);
        setWidth("100%");
    }

    public Title withWhiteSpaceNoWrap() {
        label.setWhiteSpaceNoWrap();
        return this;
    }
}
