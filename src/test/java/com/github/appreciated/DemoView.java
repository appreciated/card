package com.github.appreciated;

import com.github.appreciated.item.IconItem;
import com.github.appreciated.item.Item;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
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
                getClickableImageCard(false),
                getClickableImageCard(true),
                getClickableImageCard(true),
                new Item("Test text"),
                new Item("Test title", "Test description"),
                new IconItem(getIcon(), "Test text"),
                new IconItem(getIcon(), "Test Title", "Test Description")
        );
    }

    private Card getCard(boolean hasAction) {
        Card card =
                hasAction ? new Card(getCardUnselectableContent(), getCardActions()) : new Card(getCardUnselectableContent());
        card.setWidth("300px");
        card.setHeader("TestHeading");
        card.setElevation(currentElevation++);
        return card;
    }

    private Icon getIcon() {
        Icon icon = VaadinIcon.VAADIN_V.create();
        icon.getStyle()
                .set("width", "45px")
                .set("height", "45px")
                .set("color", "var(--lumo-primary-color)");
        return icon;
    }

    private ClickableCard getClickableCard(boolean hasAction) {
        ClickableCard card = hasAction ? new ClickableCard(getCardSelectableContent(), event -> Notification.show("Clicked!"), getCardActions()) : new ClickableCard(getCardSelectableContent(), event -> {
            Notification.show("Clicked!");
        });
        card.setWidth("300px");
        card.setElevation(currentElevation2++);
        return card;
    }

    private ClickableCard getClickableImageCard(boolean hasAction) {
        ClickableCard card = getClickableCard(hasAction);
        card.setImage(new Image("/frontend/bg.png", "bg.png"));
        card.setHeader("TestHeading");
        return card;
    }


    private Component getCardUnselectableContent() {
        return new IconItem(getIcon(), "Normal Card", "I can normal card. I show content and provide some actions below");
    }

    private Component getCardSelectableContent() {
        return new IconItem(getIcon(), "Clickable Card", "I am a clickable card. I can be clicked, I show content and provide some actions below");
    }

    private Component[] getCardActions() {
        Button b1 = new Button("Action 1");
        b1.getElement().setAttribute("theme", "tertiary");
        Button b2 = new Button("Action 2");
        b2.getElement().setAttribute("theme", "tertiary");
        return new Component[]{b1, b2};
    }
}
