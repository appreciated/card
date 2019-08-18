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
 * listener. The click events of this {@link Component} will not be passed to the click listener of the {@link StatefulCard}
 * <p>
 * The {@link StatefulCard} also increases it's "elevation" by one (f.e. var(--lumo-box-shadow-s) -> var(--lumo-box-shadow-m))
 * to make it clear to the user that it can be clicked. This element behaves in this aspect different on devices that have
 * "ontouchstart" defined than on devices that don't. The elevation raise on "hover" / "active" can be disabled {@link StatefulCard#setElevationOnActionEnabled(boolean)}
 * <p>
 * The {@link Component} classes that are by default supported are {@link ActionButton}
 * and {@link Button}. To add another {@link Component} extend this class, overwrite the
 * {@link StatefulCard#getIgnoredComponentClasses()} and append your {@link Component} to it.
 */
@Tag("stateful-card")
@JsModule("./com/github/appreciated/card/stateful-card.js")
public class StatefulCard extends AbstractCard<StatefulCard> implements ClickNotifier {

    private List<Class> ignoredClasses;

    public StatefulCard() {
        this(null);
    }

    public StatefulCard(Component... components) {
        this(null, components);
    }

    public StatefulCard(ComponentEventListener listener, Component... components) {
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

    public StatefulCard withClickListener(ComponentEventListener listener) {
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
     * Checks whether if one of the passed {@link Component} or it's children contains belongs to a class is listed in {@link StatefulCard#getIgnoredComponentClasses()}
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
     * Some JavaScripts events of a contained {@link Component} inside the {@link StatefulCard} need to be ignored.
     * To make this happen every single Child {@link Component} will need to be prevented to sent the relevant events to the {@link StatefulCard}
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
     * fluent method for {@link StatefulCard#setElevationOnActionEnabled(boolean)}
     *
     * @param enabled see {@link StatefulCard#setElevationOnActionEnabled(boolean)}
     * @return This element to allow using the method fluently
     */
    public StatefulCard withElevationOnActionEnabled(boolean enabled) {
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

    /**
     * fluent method for {@link StatefulCard#setSelected(boolean)}
     *
     * @param focus see {@link StatefulCard#setSelected(boolean)}
     * @return This element to allow using the method fluently
     */
    public StatefulCard withSelected(boolean focus) {
        setSelected(focus);
        return this;
    }

    /**
     * Allows to disable the behaviour of elevation change on "hover"(Desktop) / "active"(Mobile).
     *
     * @param selected whether the card should have focus or not
     */
    public void setSelected(boolean selected) {
        getTemplateDiv().getClassNames().set("selected", selected);
    }

}
