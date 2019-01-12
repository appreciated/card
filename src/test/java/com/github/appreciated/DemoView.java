package com.github.appreciated;

import com.github.appreciated.item.Actions;
import com.github.appreciated.item.IconItem;
import com.github.appreciated.item.Title;
import com.vaadin.flow.component.Component;
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

        add(
                //getCard(false),
//                getCard(true),
//                getCard(true),
//                getClickableCard(false),
//                getClickableCard(true),
                getClickableCard(true)
//                getClickableImageCard(false),
//                getClickableImageCard(true),
//                getClickableImageCard(true),
//                new Item("Test text"),
//                new Item("Test title", "Test description"),
//                new IconItem(getIcon(), "Test text"),
//                new IconItem(getIcon(), "Test Title", "Test Description")
        );
    }

    private Card getCard(boolean hasAction) {
        Card card =
                hasAction ? new Card(new Title("Test Title"),
                        new Image("/frontend/bg.png", "bg.png"), getCardUnselectableContent(), new Actions(new ActionButton("Action 1"), new ActionButton("Action 2"))) :
                        new Card(getCardUnselectableContent());
        card.setWidth("300px");
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
        ClickableCard card = hasAction ? new ClickableCard(event -> Notification.show("Clicked!"), getCardSelectableContent(), getActions()) : new ClickableCard(event -> {
            Notification.show("Clicked!");
        }, getCardSelectableContent());
        card.setWidth("300px");
        card.setElevation(currentElevation2++);
        return card;
    }

    private ClickableCard getClickableImageCard(boolean hasAction) {
        ClickableCard card = hasAction ? new ClickableCard(event -> Notification.show("Clicked!"), new Image("/frontend/bg.png", "bg.png"), getCardSelectableContent(), new Actions(new ActionButton("Action 1"), new ActionButton("Action 2"))) :
                new ClickableCard(event -> Notification.show("Clicked!"), getCardSelectableContent());
        card.setWidth("300px");
        card.setElevation(currentElevation2++);
        return card;
    }

    private Actions getActions() {
        ActionButton action1 = new ActionButton("Action 1", buttonClickEvent -> Notification.show("Action 1 clicked"));
        action1.setId("v-button-1");
        ActionButton action2 = new ActionButton("Action 2", buttonClickEvent -> Notification.show("Action 2 clicked"));
        return new Actions(action1, action2);
    }


    private Component getCardUnselectableContent() {
        return new IconItem(getIcon(), "Normal Card", "I can normal card. I show content and provide some actions below");
    }

    private Component getCardSelectableContent() {
        return new IconItem(getIcon(), "Clickable Card", "I am a clickable card. I can be clicked, I show content and provide some actions below");
    }
}
