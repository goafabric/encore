package org.goafabric.encore.ui.appointments;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.goafabric.encore.ui.main.MainLayout;

@PageTitle("Appointments")
@Route(value = "appointments", layout = MainLayout.class)
public class AppointmentView extends VerticalLayout {
    public AppointmentView() {
        setSizeFull();
        var calendar = new DatePicker();
        calendar.setSizeFull();
        calendar.setOpened(true);
        this.add(calendar);
    }
}