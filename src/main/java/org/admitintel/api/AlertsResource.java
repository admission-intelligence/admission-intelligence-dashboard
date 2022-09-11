package org.admitintel.api;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.admitintel.model.Alert;
import org.admitintel.service.AlertService;

@Path("/alerts")
public class AlertsResource {

    @Inject
    AlertService alertService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAlerts(List<Alert> alerts) {
        alerts.stream().forEach(alert -> alertService.createAlert(alert));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Alert> getAlerts() {

        return alertService.getAllAlerts();
    }
}
