package com.github.appreciated;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("content-card")
@HtmlImport("frontend://com/github/appreciated/card/content-card.html")
public class Card extends AbstractCard {

    public Card() {
        this(null, null);
    }

    public Card(Component content) {
        this(content, null);
    }

    public Card(Component cardUnselectableContent, Component... cardActions) {
        super(cardUnselectableContent, cardActions);
    }
}