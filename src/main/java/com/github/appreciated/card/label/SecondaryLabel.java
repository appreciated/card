package com.github.appreciated.card.label;

import com.github.appreciated.card.content.HorizontalCardComponentContainer;

public class SecondaryLabel extends HorizontalCardComponentContainer<SecondaryLabel> implements WhiteSpaceLabel {

    public SecondaryLabel(String text) {
        super(new SecondaryLabelComponent(text));
    }

    public SecondaryLabel withWhiteSpaceNoWrap() {
        setWhiteSpaceNoWrap();
        return this;
    }
}
