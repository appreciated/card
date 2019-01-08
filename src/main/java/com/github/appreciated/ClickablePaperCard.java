package com.github.appreciated;

import com.github.appreciated.ripple.PaperRipple;
import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("clickable-paper-card")
@HtmlImport("frontend://com/github/appreciated/paper-card/clickable-paper-card.html")
public class ClickablePaperCard extends PolymerTemplate<TemplateModel> implements HasComponents, FlexComponent, ClickNotifier {
    @Id("card")
    private PaperCard card;

    public ClickablePaperCard() {
        this(null, (Component) null);
    }

    public ClickablePaperCard(Component content) {
        this(content, (Component) null);
    }

    public ClickablePaperCard(Component content, Component... actions) {
        if (content != null) {
            card.add(content);
        }
        if (actions != null) {
            card.addAction(actions);
            card.getContent().getStyle().set("padding-bottom", "72px")
                    .set("margin-bottom", "-55px");
        }
        PaperRipple ripple = new PaperRipple();
        ripple.setColor("var(--lumo-shade-40pct)");
        card.add(ripple);
    }

    public ClickablePaperCard(Component content, ComponentEventListener listener) {
        this(content, (Component[]) null);
        addClickListener(listener);
    }

    public ClickablePaperCard(Component content, ComponentEventListener listener, Component... actions) {
        this(content, actions);
        addClickListener(listener);
    }

    public Registration addClickListener(ComponentEventListener listener) {
        if (this instanceof Component) {
            return ComponentUtil.addListener(card.getContent(), ClickEvent.class, listener);
        } else {
            throw new IllegalStateException(String.format("The class '%s' doesn't extend '%s'. Make your implementation for the method '%s'.", this.getClass().getName(), Component.class.getSimpleName(), "addClickListener"));
        }
    }

    public String getImage() {
        return card.getImage();
    }

    public void setImage(String path) {
        card.setImage(path);
    }

    public String getAlt() {
        return card.getAlt();
    }

    public void setAlt(String alt) {
        card.setAlt(alt);
    }

    public String getHeading() {
        return card.getHeading();
    }

    public void setHeading(String heading) {
        card.setHeading(heading);
    }


    @Override
    public void add(Component... components) {
        card.add(components);
    }

    /**
     * @param elevation
     */
    public void setElevation(int elevation) {
        if (elevation < 4 && elevation >= 0)
            card.getElement().setProperty("elevation", elevation);
    }
}
