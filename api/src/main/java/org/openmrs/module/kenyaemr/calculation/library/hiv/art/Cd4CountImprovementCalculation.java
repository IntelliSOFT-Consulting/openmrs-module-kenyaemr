package org.openmrs.module.kenyaemr.calculation.library.hiv.art;

import org.openmrs.calculation.patient.PatientCalculationContext;
import org.openmrs.calculation.result.CalculationResultMap;
import org.openmrs.calculation.result.SimpleResult;
import org.openmrs.module.kenyacore.calculation.AbstractPatientCalculation;
import org.openmrs.module.kenyacore.calculation.BooleanResult;
import org.openmrs.module.kenyaemr.calculation.EmrCalculationUtils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by codehub on 06/07/15.
 */
public class Cd4CountImprovementCalculation extends AbstractPatientCalculation {

    @Override
    public CalculationResultMap evaluate(Collection<Integer> cohort, Map<String, Object> params, PatientCalculationContext context) {
        CalculationResultMap ret = new CalculationResultMap();

        CalculationResultMap calculations = calculate(new ChangeInCd4CountCalculation(), cohort, context);

        for(Integer ptId: cohort) {
            String hasImproved = "";

            Double value = EmrCalculationUtils.resultForPatient(calculations, ptId);
            if(value != null && value > 0.0) {
                hasImproved = "Yes";
            }

            else if(value != null && value <= 0.0) {
                hasImproved = "No";
            }
            ret.put(ptId, new SimpleResult(hasImproved, this));
        }

        return ret;
    }
}
