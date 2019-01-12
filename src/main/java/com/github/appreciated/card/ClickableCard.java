package com.github.appreciated.card;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

import java.util.List;

@Tag("clickable-card")
@HtmlImport("frontend://com/github/appreciated/card/clickable-card.html")
public class ClickableCard extends AbstractCard<ClickableCard> implements ClickNotifier {

    private List<Class> ignoredClasses;

    public ClickableCard() {
        this(null);
    }

    public ClickableCard(Component... components) {
        this(null, components);
    }

    public ClickableCard(ComponentEventListener listener, Component... components) {
        super(components);
        if (listener != null) {
            addClickListener(listener);
        }
    }

    public Registration addClickListener(ComponentEventListener listener) {
        if (this instanceof Component) {
            return ComponentUtil.addListener(getContent(), ClickEvent.class, listener);
        } else {
            throw new IllegalStateException(String.format("The class '%s' doesn't extend '%s'. Make your implementation for the method '%s'.", this.getClass().getName(), Component.class.getSimpleName(), "addClickListener"));
        }
    }

    @Override
    public void add(Component... components) {
        super.add(components);
    }


    public ClickableCard withElevationOnActionEnabled(boolean enabled) {
        setElevationOnActionEnabled(enabled);
        return this;
    }

    public void setElevationOnActionEnabled(boolean enable) {
        getElement().setProperty("enableElevate", enable);
    }
}
