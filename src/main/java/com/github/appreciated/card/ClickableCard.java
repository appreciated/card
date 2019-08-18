package com.github.appreciated.card;

import com.github.appreciated.card.action.ActionButton;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
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
@JsModule("./com/github/appreciated/card/clickable-card.js")
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

    public ClickableCard withClickListener(ComponentEventListener listener) {
        addClickListener(listener);
        return this;
    }

    @Override
    public void add(Component... components) {
        super.add(components);
        if (ignoredClasses == null) {
            ignoredClasses = getIgnoredComponentClasses();
        }
        checkPreventComponentEventPropagation(Arrays.stream(components));
    }

    /**
     * Checks whether if one of the passed {@link Component} or it's children contains belongs to a class is listed in {@link ClickableCard#getIgnoredComponentClasses()}
     *
     * @param components the components that should be checked
     */
    private void checkPreventComponentEventPropagation(Stream<Component> components) {
        components.forEach(component -> {
            if (ignoredClasses.contains(component.getClass())) {
                preventElementEventPropagation(component);
            } else if (getChildren().count() > 0) {
                checkPreventComponentEventPropagation(component.getChildren());
            }
        });
    }

    /**
     * Some JavaScripts events of a contained {@link Component} inside the {@link ClickableCard} need to be ignored.
     * To make this happen every single Child {@link Component} will need to be prevented to sent the relevant events to the {@link ClickableCard}
     *
     * @return list of {@link Component} Classes that should not pass it's down / click event to the parent.
     */
    public List<Class> getIgnoredComponentClasses() {
        return Arrays.asList(Button.class, ActionButton.class);
    }

    /**
     * Prevents a Component to sent its events to this {@link Component} by sending a method to the client-sided couterpart
     */
    private void preventElementEventPropagation(Component component) {
        getElement().callJsFunction("preventElementEventPropagation", component.getElement());
    }

    /**
     * fluent method for {@link ClickableCard#setElevationOnActionEnabled(boolean)}
     *
     * @param enabled see {@link ClickableCard#setElevationOnActionEnabled(boolean)}
     * @return This element to allow using the method fluently
     */
    public ClickableCard withElevationOnActionEnabled(boolean enabled) {
        setElevationOnActionEnabled(enabled);
        return this;
    }

    /**
     * Allows to disable the behaviour of elevation change on "hover"(Desktop) / "active"(Mobile).
     *
     * @param enable whether the elevation change should be enabled or not
     */
    public void setElevationOnActionEnabled(boolean enable) {
        getElement().setProperty("elevationEnabled", enable);
    }
}
