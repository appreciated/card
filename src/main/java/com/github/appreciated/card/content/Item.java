package com.github.appreciated.card.content;

import com.github.appreciated.card.label.PrimaryLabelComponent;
import com.vaadin.flow.component.Component;


public class Item extends HorizontalCardComponentContainer {

    private Component component;

    public Item(String title, String description) {
        component = new ItemBody(title, description);
        ((ItemBody) component).setPadding(false);
        add(component);
    }

    public Item withWhiteSpaceNoWrap() {
        if (component instanceof PrimaryLabelComponent) {
            ((PrimaryLabelComponent) component).setWhiteSpaceNoWrap();
        } else if (component instanceof ItemBody) {
            ((ItemBody) component).withWhiteSpaceNoWrap();
        }
        return this;
    }

}
