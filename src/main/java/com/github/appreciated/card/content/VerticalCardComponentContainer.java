package com.github.appreciated.card.content;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class VerticalCardComponentContainer extends VerticalLayout {
    public VerticalCardComponentContainer() {
        setPadding(true);
        setMargin(false);
    }

    public VerticalCardComponentContainer(Component... children) {
        super(children);
        setPadding(true);
        setMargin(false);
    }

}
