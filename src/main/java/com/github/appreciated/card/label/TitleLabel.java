package com.github.appreciated.card.label;

import com.github.appreciated.card.content.HorizontalCardComponentContainer;

public class TitleLabel extends HorizontalCardComponentContainer<TitleLabel> implements WhiteSpaceLabel {

    public TitleLabel(String text) {
        super(new TitleLabelComponent(text));
    }

    public TitleLabel withWhiteSpaceNoWrap() {
        setWhiteSpaceNoWrap();
        return this;
    }
}