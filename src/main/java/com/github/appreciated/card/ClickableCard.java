package com.github.appreciated.card;

import com.github.appreciated.card.action.ActionButton;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Similar to {@link Card} but you can add a click listener to it.
 * The convenience feature this component offers is that you can add a {@link Component} to it which has their own click
 * listener. The click events of this {@link Component} will not be passed to the click listener of the {@link ClickableCard}
 * <p>
 * The {@link ClickableCard} also increases it's "elevation" by one (f.e. var(--lumo-box-shadow-s) -> var(--lumo-box-shadow-m))
 * to make it clear to the user that it can be clicked. This element behaves in this aspect different on devices that have
 * "ontouchstart" defined than on devices that don't. The elevation raise on "hover" / "active" can be disabled {@link ClickableCard#setElevationOnActionEnabled(boolean)}
 * <p>
 * The {@link Component} classes that are by default supported are {@link com.github.appreciated.card.action.ActionButton}
 * and {@link com.vaadin.flow.component.button.Button}. To add another {@link Component} extend this class, overwrite the
 * {@link ClickableCard#getIgnoredComponentClasses()} and append your {@link Component} to it.
 */
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
        if (ignoredClasses == null) {
            ignoredClasses = getIgnoredComponentClasses();
        }
        checkPreventComponentEventPropagation(Arrays.stream(components));
    }

    private void checkPreventComponentEventPropagation(Stream<Component> components) {
        components.forEach(component -> {
            if (ignoredClasses.contains(component.getClass())) {
                preventElementEventPropagation(component);
            } else if (component instanceof HasOrderedComponents &&
                    ((HasOrderedComponents) component).getComponentCount() > 0) {
                checkPreventComponentEventPropagation(component.getChildren());
            }
        });
    }

    /**
     * Some JavaScripts events of a contained {@link Component} inside the {@link RippleClickableCard} need to be ignored.
     * To make this happen every single Child {@link Component} will need to be prevented to sent the relevant events to the {@link RippleClickableCard}
     *
     * @return
     */
    public List<Class> getIgnoredComponentClasses() {
        return Arrays.asList(Button.class, ActionButton.class);
    }

    /**
     * Prevent the Component to sent its
     */
    private void preventElementEventPropagation(Component component) {
        getElement().callFunction("preventElementEventPropagation", component.getElement());
    }


    public ClickableCard withElevationOnActionEnabled(boolean enabled) {
        setElevationOnActionEnabled(enabled);
        return this;
    }

    public void setElevationOnActionEnabled(boolean enable) {
        getElement().setProperty("elevationEnabled", enable);
    }
}
