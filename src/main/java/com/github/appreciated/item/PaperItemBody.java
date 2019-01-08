package com.github.appreciated.item;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;

@Tag("paper-item-body")
@HtmlImport("bower_components/paper-item/paper-item-body.html")
public class PaperItemBody extends Component implements HasComponents {
    public PaperItemBody(Component first, Component second) {
        add(first, second);
    }

    public PaperItemBody(String title, String description) {
        Div first = new Div();
        first.getElement().setText(title);
        Div second = new Div();
        second.getElement().setAttribute("secondary", true);
        second.getElement().setText(description);
        add(first, second);
    }
}
