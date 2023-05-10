package org.goafabric.encore.ui.settings;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.TabSheet;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.ui.main.MainLayout;

@Route(value = "settings", layout = MainLayout.class)
@PageTitle("Settings")
public class SettingsController extends VerticalLayout {

    public SettingsController() {
        this.setSizeFull();

        TabSheet tabSheet = new TabSheet();
        tabSheet.setSizeFull();

        tabSheet.add("Dashboard",
                new Div(new Text("This is the Dashboard tab content")));

        tabSheet.add("Payment",
                new Div(new Text("This is the Payment tab content")));

        add(tabSheet);
    }
}
