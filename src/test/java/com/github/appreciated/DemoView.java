package com.github.appreciated;

import com.github.appreciated.item.IconItem;
import com.github.appreciated.item.Item;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class DemoView extends VerticalLayout {

    static int currentElevation = 0;
    static int currentElevation2 = 0;

    public DemoView() {

        add(getCard(false),
                getCard(true),
                getCard(true),
                getClickableCard(false),
                getClickableCard(true),
                getClickableCard(true),
                new Item("Test text"),
                new Item("Test title", "Test description"),
                new IconItem(VaadinIcon.ANGLE_LEFT.create(), "Test text"),
                new IconItem(VaadinIcon.ANGLE_LEFT.create(), "Test Title", "Test Description")
        );
    }

    private PaperCard getCard(boolean hasAction) {
        PaperCard card =
                hasAction ? new PaperCard(getCardContent(), getCardActions()) : new PaperCard(getCardContent());
        card.setWidth("300px");
        card.setHeading("TestHeading");
        card.setElevation(currentElevation++);
        return card;
    }

    private ClickablePaperCard getClickableCard(boolean hasAction) {
        ClickablePaperCard card = hasAction ? new ClickablePaperCard(getCardContent(), event -> Notification.show("Clicked!"), getCardActions()) : new ClickablePaperCard(getCardContent(), event -> {
            Notification.show("Clicked!");
        });
        card.setWidth("300px");
        card.setElevation(currentElevation2++);
        return card;
    }

    private Component getCardContent() {
        return new IconItem(VaadinIcon.ANGLE_LEFT.create(), "Test Title", "A much longer test Description for testing reasons :-P");
    }

    private Component[] getCardActions() {
        Button b1 = new Button("Button 1");
        b1.getElement().setAttribute("theme", "tertiary");
        Button b2 = new Button("Button 2");
        b2.getElement().setAttribute("theme", "tertiary");
        return new Component[]{b1, b2};
    }
}
