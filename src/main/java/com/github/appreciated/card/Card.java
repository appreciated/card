package com.github.appreciated.card;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

/**
 * A component very similar to the @{<paper-card> } Webcomponent
 */
@Tag("content-card")
@HtmlImport("frontend://com/github/appreciated/card/content-card.html")
public class Card extends AbstractCard<Card> {

    public Card() {
        this(null);
    }

    public Card(Component... components) {
        super(components);
    }
}