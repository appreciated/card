package com.github.appreciated.card.content;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HorizontalCardComponentContainer extends HorizontalLayout {
    public HorizontalCardComponentContainer() {
        setPadding(true);
        setWidth("100%");
    }

    public HorizontalCardComponentContainer(Component... children) {
        super(children);
        setPadding(true);
        setWidth("100%");
    }


}
