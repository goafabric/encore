package org.goafabric.encore.ui.chat;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.ui.MainView;


@Route(value = "chat", layout = MainView.class)
@PageTitle("Chat")
public class ChatView extends VerticalLayout {
    public ChatView() {
        createView();
    }

    private void createView() {
        setSizeFull();
        var messages = new TextField();
        messages.setSizeFull();

        var inputField = new TextField();
        var sendButton = new Button("send");

        this.add(messages);
        this.add(new HorizontalLayout(inputField, sendButton));

        sendButton.addClickShortcut(Key.ENTER);

    }
}
