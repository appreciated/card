package com.github.appreciated;

import com.github.appreciated.ripple.PaperRipple;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

@Tag("clickable-card")
@HtmlImport("frontend://com/github/appreciated/card/clickable-card.html")
public class ClickableCard extends AbstractCard implements ClickNotifier {

    public ClickableCard() {
        this(null);
    }

    public ClickableCard(Component content) {
        this(content, null);
    }

    public ClickableCard(Component content, Component... cardActions) {
        this(content, null, cardActions);
    }

    public ClickableCard(Component cardSelectableContent, ComponentEventListener listener, Component... cardActions) {
        super(cardSelectableContent, cardActions);
        if (listener != null) {
            addClickListener(listener);
        }
        PaperRipple ripple = new PaperRipple();
        ripple.getElement().getStyle().set("margin", "unset");
        getContent().add(ripple);
    }

    public Registration addClickListener(ComponentEventListener listener) {
        if (this instanceof Component) {
            return ComponentUtil.addListener(getContent(), ClickEvent.class, listener);
        } else {
            throw new IllegalStateException(String.format("The class '%s' doesn't extend '%s'. Make your implementation for the method '%s'.", this.getClass().getName(), Component.class.getSimpleName(), "addClickListener"));
        }
    }
}
