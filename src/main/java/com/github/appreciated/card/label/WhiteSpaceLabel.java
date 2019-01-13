package com.github.appreciated.card.label;

import com.vaadin.flow.component.HasElement;

public interface WhiteSpaceLabel extends HasElement {
    default void setWhiteSpace(String value) {
        getElement().getStyle().set("white-space", value);
    }

    default void setWhiteSpaceNoWrap() {
        getElement().getStyle().set("white-space", "nowrap");
    }
}
