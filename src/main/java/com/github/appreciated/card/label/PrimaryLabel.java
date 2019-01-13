package com.github.appreciated.card.label;

import com.github.appreciated.card.content.HorizontalCardComponentContainer;

public class PrimaryLabel extends HorizontalCardComponentContainer implements WhiteSpaceLabel {

    public PrimaryLabel(String text) {
        super(new PrimaryLabelComponent(text));
    }

    public PrimaryLabel withWhiteSpaceNoWrap() {
        setWhiteSpaceNoWrap();
        return this;
    }
}
