package com.github.appreciated;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;

/**
 * Convenience Button class which simply contains all the Constructors of the {@link Button} parent class
 */
public class ActionButton extends Button {

    public ActionButton() {
        super();
        setTertiaryTheme();
    }

    public ActionButton(String text) {
        super(text);
        setTertiaryTheme();
    }

    public ActionButton(Component icon) {
        super(icon);
        setTertiaryTheme();
    }

    public ActionButton(String text, Component icon) {
        super(text, icon);
        setTertiaryTheme();
    }

    public ActionButton(String text, ComponentEventListener<ClickEvent<Button>> clickListener) {
        super(text, clickListener);
        setTertiaryTheme();
    }

    public ActionButton(Component icon, ComponentEventListener<ClickEvent<Button>> clickListener) {
        super(icon, clickListener);
        setTertiaryTheme();
    }

    public ActionButton(String text, Component icon, ComponentEventListener<ClickEvent<Button>> clickListener) {
        super(text, icon, clickListener);
        setTertiaryTheme();
    }

    private void setTertiaryTheme() {
        getElement().setAttribute("theme", "tertiary");
    }

}
