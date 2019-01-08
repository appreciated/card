package com.github.appreciated.item;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;

@Tag("paper-icon-item")
@HtmlImport("bower_components/paper-item/paper-icon-item.html")
public class PaperIconItem extends Component implements HasComponents {
    public PaperIconItem(Icon icon, Component component) {
        add(icon, component);
        icon.getElement().setAttribute("slot", "item-icon");
        setSelectable(false);
    }

    public PaperIconItem(Icon icon, String title) {
        this(icon, new Label(title));
    }

    public PaperIconItem(Icon icon, String title, String description) {
        this(icon, new PaperItemBody(title, description));
    }

    public void setSelectable(boolean selectable) {
        if (selectable) {
            getElement().getStyle().remove("pointer-events");
        } else {
            getElement().getStyle().set("pointer-events", "none").set("user-select","none");
        }
    }
}