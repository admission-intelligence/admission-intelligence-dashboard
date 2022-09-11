package org.admitintel.service;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import org.admitintel.model.Outcome;
import org.admitintel.model.OutcomeProgram;

@ApplicationScoped
public class OutcomeService {

    private NumberFormat usd = NumberFormat.getCurrencyInstance(Locale.US);
    @Transactional
    public void createOutcome(Outcome outcome) {
        outcome.persist();
    }

    @Transactional
    public void createProgram(OutcomeProgram program) {
        program.persist();
    }

    public List<Outcome> getAllOutcomes() {
       return Outcome.listAll();
    }

    public Double getTotalOutcomeValue(){
        return 1452.0;
    }

    public  Map<String, Integer> getOutcomeCategories() {
        List<Outcome> outcomes = Outcome.listAll();

        Map<String, List<Outcome>> categories = new HashMap<>();
        if(outcomes !=null && !outcomes.isEmpty()) {
            categories = outcomes.stream().collect(Collectors.groupingBy(Outcome::getCategory));
        }

        Map<String, Integer> categoryCounts = new HashMap<>();
        categories.entrySet().stream().forEach((entry) -> categoryCounts.put(entry.getKey(), entry.getValue().size()));

        return categoryCounts;
    }

    public Double getEstimatedPreventable(long id ){
        return 14525.0;
    }
}
