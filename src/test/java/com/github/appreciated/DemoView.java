package com.github.appreciated;

import com.github.appreciated.card.Card;
import com.github.appreciated.card.ClickableCard;
import com.github.appreciated.card.RippleClickableCard;
import com.github.appreciated.card.action.ActionButton;
import com.github.appreciated.card.action.Actions;
import com.github.appreciated.card.content.IconItem;
import com.github.appreciated.card.content.Item;
import com.github.appreciated.card.content.Title;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.BodySize;
import com.vaadin.flow.router.Route;

@Route("")
@BodySize(width = "100%", height = "100%")
public class DemoView extends VerticalLayout {

    int currentElevation = 0;
    int currentElevation1 = 0;
    int currentElevation2 = 0;
    int currentElevation3 = 0;

    public DemoView() {
        setMargin(false);
        add(
                //getCard(false),
                getCard(true),
                getCard(true),
                getClickableCard(false),
                getClickableCard(true),
                getClickableCard(true),
                getClickableCard(true),
                getClickableImageCard(false),
                getClickableImageCard(true),
                getClickableImageCard(true),
                getClickableNoElevationOnClickImageCard(false),
                getClickableNoElevationOnClickImageCard(true),
                getClickableNoElevationOnClickImageCard(true)
//                new Item("Test text"),
//                new Item("Test title", "Test description"),
//                new IconItem(getIcon(), "Test text"),
//                new IconItem(getIcon(), "Test Title", "Test Description")
        );
    }

    private Component getClickableNoElevationOnClickImageCard(boolean b) {
        RippleClickableCard card = getClickableImageCard(b).withElevationOnActionEnabled(false);
        card.setElevation(currentElevation3++);
        return card;
    }

    private Card getCard(boolean hasAction) {
        Card card =
                hasAction ? new Card(new Title("Test Title"),
                        new Image("/frontend/bg.png", "bg.png"), getCardUnselectableContent(), getActions()) :
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
        ClickableCard card = hasAction ? new ClickableCard(event -> Notification.show("Clicked!"), getCardSelectableContent(), getActions()) : new ClickableCard(event -> Notification.show("Clicked!"), getCardSelectableContent());
        card.setWidth("300px");
        card.setElevation(currentElevation1++);
        return card;
    }

    private RippleClickableCard getClickableImageCard(boolean hasAction) {
        RippleClickableCard card = hasAction ? new RippleClickableCard(event -> Notification.show("Clicked!"), getClickableImageCardActionContent()) :
                new RippleClickableCard(event -> Notification.show("Clicked!"), getClickableImageCardContent());
        card.setWidth("300px");
        card.setElevation(currentElevation2++);
        return card;
    }

    private Actions getActions() {
        return new Actions(
                new ActionButton("Action 1", buttonClickEvent -> Notification.show("Action 1 clicked")),
                new ActionButton("Action 2", buttonClickEvent -> Notification.show("Action 2 clicked"))
        );
    }

    private Component getCardUnselectableContent() {
        return new IconItem(getIcon(), "Normal Card", "I can normal card. I show content and provide some actions below");
    }

    private Component getCardSelectableContent() {
        return new IconItem(getIcon(), "Clickable Card", "I am a clickable card. I can be clicked, I show content and provide some actions below");
    }

    private Component[] getClickableImageCardContent() {
        return new Component[]{new Image("/frontend/bg.png", "bg.png"), new Item("Clickable Image Card")};
    }

    private Component[] getClickableImageCardActionContent() {
        IronCollapse collapse = new IronCollapse(new VerticalLayout(getExampleContent(), getExampleContent(), getExampleContent()));
        return new Component[]{new Image("/frontend/bg.png", "bg.png"), collapse, new Actions(new ActionButton("Expand", buttonClickEvent -> collapse.toggle()))};
    }

    private Component getExampleContent() {
        return new IconItem(getIcon(), "Example", "I got expanded with Iron-Collapse!");
    }

}
