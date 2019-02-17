package com.github.appreciated.card.content;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class HorizontalCardComponentContainer<T> extends HorizontalLayout {
    public HorizontalCardComponentContainer() {
        setPadding(true);
        setWidth("100%");
    }

    public HorizontalCardComponentContainer(Component... children) {
        super(children);
        setPadding(true);
        setWidth("100%");
    }

    public T withPadding(String padding) {
        setPadding(padding);
        return (T) this;
    }

    public void setPadding(String padding) {
        getElement().getStyle().set("--lumo-space-m", padding);
    }


}
