/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.reporting.cohort.definition.evaluator.covid;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openmrs.Cohort;
import org.openmrs.api.context.Context;
import org.openmrs.module.kenyaemr.reporting.cohort.definition.covid.PatientsEnrolledOnCovidCohortDefinition;
import org.openmrs.module.kenyaemr.test.StandaloneContextSensitiveTest;
import org.openmrs.module.reporting.cohort.definition.service.CohortDefinitionService;
import org.openmrs.module.reporting.common.DateUtil;

public class PatientsEnrolledOnCovidCohortDefinitionEvaluatorTest extends StandaloneContextSensitiveTest{

    @Before
    public void initialize() throws Exception {
        
        executeDataSet("dataset/etl_data.xml");
        
    }	
	    
	/**
	 * @see PatientsEnrolledOnCovidCohortDefinitionEvaluator#evaluate(CohortDefinition,EvaluationContext)
	 * @verifies find patients in Covid program filtered by county
	 */
	@Test
	public void evaluate_shouldFindPatientsInCovidProgramFilteredByCounty() throws Exception {
		PatientsEnrolledOnCovidCohortDefinition cd = new PatientsEnrolledOnCovidCohortDefinition();
		cd.setStartDate(DateUtil.getDateTime(2020, 4, 8));
		cd.setEndDate(DateUtil.getDateTime(2020, 4, 8));
		
		Cohort c = Context.getService(CohortDefinitionService.class).evaluate(cd, null);
				Assert.assertTrue(c.getSize() == 1);

	}
}