package org.goafabric.encore.ui;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoUtility;
import org.goafabric.encore.ui.appointments.AppointmentView;
import org.goafabric.encore.ui.catalogs.CatalogView;
import org.goafabric.encore.ui.monitoring.MonitoringView;
import org.goafabric.encore.ui.practice.PracticeView;

//@Route(value = "")
public class MainLayout extends AppLayout {

    private boolean darkness = false;

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Encore");
        logo.addClassNames(
                LumoUtility.FontSize.LARGE,
                LumoUtility.Margin.MEDIUM);

        var header = new HorizontalLayout(new DrawerToggle(), createHomeButton(), createDarkToggle());

        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidthFull();
        header.addClassNames(
                LumoUtility.Padding.Vertical.NONE,
                LumoUtility.Padding.Horizontal.MEDIUM);

        addToNavbar(header);

    }

    private void createDrawer() {
        addToDrawer(new VerticalLayout(
                new HorizontalLayout(new Icon(VaadinIcon.USER), new RouterLink("Practice", PracticeView.class)),
                new HorizontalLayout(new Icon(VaadinIcon.BOOK), new RouterLink("Catalogs", CatalogView.class)),
                new HorizontalLayout(new Icon(VaadinIcon.CALENDAR), new RouterLink("Calendar", AppointmentView.class)),
                new HorizontalLayout(new Icon(VaadinIcon.CHART), new RouterLink("Monitoring", MonitoringView.class))
        ));
    }

    private Button createDarkToggle() {
        Button button  = new Button(new Icon(VaadinIcon.COFFEE));
        button.addClickListener((ComponentEventListener<ClickEvent<Button>>) event -> {
            darkness = !darkness;
            getElement().executeJs("document.documentElement.setAttribute('theme', $0)", darkness ? Lumo.DARK : Lumo.LIGHT);
        });
        return button;
    }

    private Button createHomeButton() {
        var button = new Button(VaadinIcon.HOME.create());
        button.addClickListener((ComponentEventListener<ClickEvent<Button>>) event -> getUI().get().getPage().setLocation("/"));
        return button;
    }
}