package org.admitintel.api;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.admitintel.model.Outcome;
import org.admitintel.service.OutcomeService;

@Path("/outcomes")
public class OutcomeResource {

    @Inject
    OutcomeService outcomeService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addOutcomes(List<Outcome> outcomes) {
        outcomes.stream().forEach(outcome -> outcomeService.createOutcome(outcome));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Outcome> getOutcomes() {
        return outcomeService.getAllOutcomes();
    }

    @GET
    @Path("/totalOutcomes")
    @Produces(MediaType.APPLICATION_JSON)
    public Double getTotalOutcomeValue() {
        return outcomeService.getTotalOutcomeValue();
    }

    @GET
    @Path("/categoryCounts")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String, Integer> getCategoryCounts() {
        return outcomeService.getOutcomeCategories();
    }


    @GET
    @Path("/estimatedCost/{programId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Double getEstimatedPreventable(@PathParam("programId")long programId) {
        return outcomeService.getEstimatedPreventable(programId);
    }

}
