package com.github.appreciated;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

@Tag("clickable-paper-card")
@HtmlImport("frontend://com/github/appreciated/paper-card/clickable-paper-card.html")
public class ClickablePaperCard extends PolymerTemplate<TemplateModel> implements HasComponents, FlexComponent {
    @Id("card")
    private PaperCard card;

    public ClickablePaperCard() {
        this(null, null);
    }

    public ClickablePaperCard(Component content) {
        this(content, null);
    }

    public ClickablePaperCard(Component content, Component... actions) {
        if (content != null) {
            card.add(content);
        }
        if (actions != null) {
            card.addAction(actions);
        }
    }

    @Override
    public void add(Component... components) {
        card.add(components);
    }

    /**
     * @param elevation
     */
    public void setElevation(int elevation) {
        if (elevation < 5 && elevation >= 0)
            card.getElement().setProperty("elevation", elevation);
    }
}
