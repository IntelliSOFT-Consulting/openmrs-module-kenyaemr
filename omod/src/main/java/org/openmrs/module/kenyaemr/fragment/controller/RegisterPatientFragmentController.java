/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.fragment.controller;

import org.openmrs.Patient;
import org.openmrs.module.registrationcore.api.RegistrationCoreService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.action.FailureResult;
import org.openmrs.ui.framework.fragment.action.FragmentActionResult;
import org.openmrs.ui.framework.fragment.action.SuccessResult;
import org.springframework.web.bind.annotation.RequestParam;

public class RegisterPatientFragmentController {
    public FragmentActionResult importMpiPatient(@RequestParam("mpiPersonId") String personId,
	            @SpringBean("registrationCoreService") RegistrationCoreService registrationService) {
    	try {
    		Patient patient = registrationService.importMpiPatient(personId);
    		return new SuccessResult(patient.getPatientId().toString());    		
		}
		catch (Exception e) {
			return new FailureResult(e.getMessage());
		}
	}

}