package com.github.appreciated.card;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Arrays;
import java.util.function.Consumer;

public class StatefulCardGroup<T extends StatefulCard> extends VerticalLayout {
    StatefulCard currentFocus;
    private Consumer<T> listener;

    public StatefulCardGroup(T... children) {
        super(children);
        Arrays.stream(children).forEach(card -> card.addClickListener(event -> setFocus(card)));
        setMargin(false);
        setPadding(false);
        setSpacing(false);
    }

    private void setFocus(T nextFocus) {
        if (nextFocus != currentFocus) {
            nextFocus.setFocus(true);
            if (currentFocus != null) {
                currentFocus.setFocus(false);
            }
            currentFocus = nextFocus;
            if (listener != null) {
                listener.accept(nextFocus);
            }
        }
    }

    public StatefulCardGroup<T> withStateChangedListener(Consumer<T> listener) {
        setStateChangedListener(listener);
        return this;
    }

    public void setStateChangedListener(Consumer<T> listener) {
        this.listener = listener;
    }
}
