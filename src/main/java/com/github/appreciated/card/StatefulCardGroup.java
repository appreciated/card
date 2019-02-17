package com.github.appreciated.card;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;

public class StatefulCardGroup extends VerticalLayout {
    StatefulCard currentFocus;

    public StatefulCardGroup(StatefulCard... children) {
        super(children);
        Arrays.stream(children).forEach(card -> card.addClickListener(event -> setFocus(card)));
        setMargin(false);
        setPadding(false);
        setSpacing(false);
    }

    private void setFocus(StatefulCard nextFocus) {
        nextFocus.setFocus(true);
        if (currentFocus != null) {
            currentFocus.setFocus(false);
        }
        currentFocus = nextFocus;
    }

}
