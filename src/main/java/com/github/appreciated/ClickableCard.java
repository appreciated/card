package com.github.appreciated;

import com.github.appreciated.ripple.PaperRipple;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.shared.Registration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Tag("clickable-card")
@HtmlImport("frontend://com/github/appreciated/card/clickable-card.html")
public class ClickableCard extends AbstractCard implements ClickNotifier {

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
        PaperRipple ripple = new PaperRipple();
        ripple.getElement().getStyle().set("margin", "unset");
        add(ripple);
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
     * Some JavaScripts events of a contained {@link Component} inside the {@link ClickableCard} need to be ignored.
     * To make this happen every single Child {@link Component} will need to be prevented to sent the relevant events to the {@link ClickableCard}
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
        getElement().setProperty("enableElevate", enable);
    }
}
