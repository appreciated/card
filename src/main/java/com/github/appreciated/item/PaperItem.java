package com.github.appreciated.item;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;

@Tag("paper-item")
@HtmlImport("bower_components/paper-item/paper-item.html")
public class PaperItem extends Component implements HasComponents {

    public PaperItem() {
        setSelectable(false);
    }

    public PaperItem(Component... component) {
        this();
        add(component);
    }

    public PaperItem(String text) {
        this();
        getElement().setText(text);
    }


    public void setSelectable(boolean selectable) {
        if (selectable) {
            getElement().getStyle().remove("pointer-events");
        } else {
            getElement().getStyle().set("pointer-events", "none").set("user-select","none");
        }
    }
}
