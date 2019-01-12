package com.github.appreciated.card;

import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.ripple.PaperRipple;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Tag("clickable-card")
@HtmlImport("frontend://com/github/appreciated/card/clickable-card.html")
public class RippleClickableCard extends ClickableCard implements ClickNotifier {

    private List<Class> ignoredClasses;

    public RippleClickableCard() {
        this(null);
    }

    public RippleClickableCard(Component... components) {
        this(null, components);
    }

    public RippleClickableCard(ComponentEventListener listener, Component... components) {
        super(components);
        PaperRipple ripple = new PaperRipple();
        ripple.setColor("var(--lumo-shade-30pct)");
        ripple.getElement().getStyle().set("margin", "unset");
        add(ripple);
    }

    public RippleClickableCard withElevation(int elevation) {
        super.setElevation(elevation);
        return this;
    }

    public RippleClickableCard withElevationOnActionEnabled(boolean enabled) {
        setElevationOnActionEnabled(enabled);
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

    public RippleClickableCard withRippleEnabled(boolean enable) {
        setRippleEnabled(enable);
        return this;
    }

    public void setRippleEnabled(boolean enable) {
    }
}
