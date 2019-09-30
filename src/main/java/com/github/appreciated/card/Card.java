package com.github.appreciated.card;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

/**
 * A component very similar to the &lt;paper-card&gt; Webcomponent
 */
@Tag("content-card")
@JsModule("./com/github/appreciated/card/content-card.js")
public class Card extends AbstractCard<Card> {

    public Card() {
        this(null);
    }

    public Card(Component... components) {
        super(components);
    }
}