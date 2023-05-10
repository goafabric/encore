package org.goafabric.encore.ui.main;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("main")
public class MainView extends VerticalLayout {
    public MainView() {
        setSizeFull();
        this.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        //this.setAlignItems(Alignment.CENTER);
        this.add(new Image("images/logo.png", ""));
    }
}
