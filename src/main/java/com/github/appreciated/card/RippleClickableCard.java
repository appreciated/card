package com.github.appreciated.card;

import com.github.appreciated.ripple.PaperRipple;
import com.vaadin.flow.component.ClickNotifier;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;

/**
 * Similar to {@link ClickableCard} but it has a {@link PaperRipple}.
 * The additional convenience feature this component is that you can add a {@link Component} to it which has their own click
 * listener. The down events of this {@link Component} will not be passed to the down listener of the {@link PaperRipple}
 * so the {@link PaperRipple} effect will only be visible if you click on an non clickable element.
 * <p>
 * The {@link RippleClickableCard} also increases it's "elevation" by one (f.e. var(--lumo-box-shadow-s) will be increased to var(--lumo-box-shadow-m))
 * to make it clear to the user that it can be clicked. This element behaves in this aspect different on devices that have
 * "ontouchstart" defined than on devices that don't. The elevation raise on "hover" / "active" can be disabled {@link ClickableCard#setElevationOnActionEnabled(boolean)}
 * <p>
 * The {@link Component} classes that are by default supported are {@link com.github.appreciated.card.action.ActionButton}
 * and {@link com.vaadin.flow.component.button.Button}. To add another {@link Component} extend this class, overwrite the
 * {@link RippleClickableCard#getIgnoredComponentClasses()} and append your {@link Component} to it.
 */

public class RippleClickableCard extends ClickableCard implements ClickNotifier {

    private final PaperRipple ripple;

    public RippleClickableCard() {
        this(null);
    }

    public RippleClickableCard(Component... components) {
        this(null, components);
    }

    public RippleClickableCard(ComponentEventListener listener, Component... components) {
        super(listener, components);
        ripple = new PaperRipple();
        ripple.setColor("var(--lumo-contrast-30pct, var(--material-disabled-color))");
        ripple.getElement().getStyle().set("margin", "unset");
        add(ripple);
    }

    /**
     * Convenience fluent method to return {@link RippleClickableCard} instead of {@link ClickableCard}
     *
     * @param elevation
     * @return
     */
    public RippleClickableCard withElevation(int elevation) {
        super.setElevation(elevation);
        return this;
    }


    /**
     * Sets the elevation of this card. Value can only be in range from 0-4 (--lumo-box-shadow-s) will be increased to --lumo-box-shadow-l))
     * 4 because there need to be some space for elevation.
     *
     * @param elevation
     */
    public void setElevation(int elevation) {
        if (elevation < 6 && elevation >= 0)
            super.setElevation(elevation);
    }

    /**
     * Convenience fluent method to return {@link RippleClickableCard} instead of {@link ClickableCard}
     *
     * @param enabled see {@link ClickableCard#setElevationOnActionEnabled(boolean)}
     * @return
     */
    public RippleClickableCard withElevationOnActionEnabled(boolean enabled) {
        setElevationOnActionEnabled(enabled);
        return this;
    }

    /**
     * Allows to access the {@link PaperRipple} that is used by this {@link Component} for configurability
     * @return the {@link PaperRipple} instance
     */
    public PaperRipple getRipple() {
        return ripple;
    }
}
