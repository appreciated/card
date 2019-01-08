package com.github.appreciated;

import com.github.appreciated.item.PaperIconItem;
import com.github.appreciated.item.PaperItem;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class DemoView extends VerticalLayout {

    static int currentElevation = 0;

    public DemoView() {

        add(getCard(),
                getCard(),
                getCard(),
                getCard(),
                getCard(),
                getCard(),
                new PaperItem("Test text"),
                new PaperIconItem(VaadinIcon.ANGLE_LEFT.create(), "Test text"),
                new PaperIconItem(VaadinIcon.ANGLE_LEFT.create(), "Test Title", "Test Description")
        );
    }

    private PaperCard getCard() {
        PaperCard card = new PaperCard(getCardContent(), getCardActions());
        card.setWidth("300px");
        card.setElevation(currentElevation++);
        return card;
    }

    private Component getCardContent() {
        return new PaperIconItem(VaadinIcon.ANGLE_LEFT.create(), "Test Title", "A much longer test Description for testing reasons :-P");
    }

    private Component getCardActions() {
        Button b1 = new Button("Button 1");
        b1.getElement().setAttribute("theme", "tertiary");
        Button b2 = new Button("Button 2");
        b2.getElement().setAttribute("theme", "tertiary");
        return new HorizontalLayout(b1, b2);
    }
}
