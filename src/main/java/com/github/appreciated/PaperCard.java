package com.github.appreciated;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.FlexComponent;

import java.util.Objects;

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

    public PaperCard(Component content, Component... actions) {
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

    public String getImage() {
        return getElement().getAttribute("image");
    }

    public void setImage(String path) {
        getElement().setAttribute("image", path);
    }

    public String getAlt() {
        return getElement().getAttribute("alt");
    }

    public void setAlt(String alt) {
        getElement().setAttribute("alt", alt);
    }

    public String getHeading() {
        return getElement().getAttribute("heading");
    }

    public void setHeading(String heading) {
        getElement().setAttribute("heading", heading);
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
        Objects.requireNonNull(components, "Components should not be null");
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