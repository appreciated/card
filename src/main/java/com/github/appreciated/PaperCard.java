package com.github.appreciated;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

@Tag("paper-card")
@HtmlImport("bower_components/paper-card/paper-card.html")
public class PaperCard extends Component implements HasComponents, FlexComponent {
    private Div content;
    private Div actions;

    public PaperCard() {
        this(null, null);
    }

    public PaperCard(Component content) {
        this(content, null);
    }

    public PaperCard(Component content, Component actions) {
        getElement().getStyle()
                .set("--paper-material-elevation-1_-_box-shadow", "var(--lumo-box-shadow-s)")
                .set("--paper-material-elevation-2_-_box-shadow", "var(--lumo-box-shadow-m)")
                .set("--paper-material-elevation-3_-_box-shadow", "var(--lumo-box-shadow-l)")
                .set("--paper-material-elevation-4_-_box-shadow", "var(--lumo-box-shadow-xl)");
        if (content != null) {
            add(content);
        }
        if (actions != null) {
            addAction(actions);
        }
    }

    /**
     * @param elevation
     */
    public void setElevation(int elevation) {
        if (elevation < 5 && elevation >= 0)
            getElement().setProperty("elevation", elevation);
    }

    /**
     *
     */
    public int getElevation() {
        return Integer.parseInt(getElement().getProperty("elevation"));
    }


    public void setHeader(String header) {
        getElement().setAttribute("heading", header);
    }

    @Override
    public void add(Component... components) {
        if (content == null) {
            content = new Div();
            content.getElement().getClassList().add("card-content");
            getElement().appendChild(content.getElement());
        }
        content.add(components);
    }

    public void addAction(Component... components) {
        if (actions == null) {
            actions = new Div();
            actions.getElement().getClassList().add("card-actions");
            getElement().appendChild(actions.getElement());
        }
        actions.add(components);
    }

    public Div getContent() {
        return content;
    }

    public Div getActions() {
        return actions;
    }
}