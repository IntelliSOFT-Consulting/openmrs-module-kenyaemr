/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */

package org.openmrs.module.kenyaemr.reporting.library.shared.hiv;

import org.openmrs.module.kenyaemr.reporting.library.shared.hiv.art.ArtCohortLibrary;
import org.openmrs.module.kenyaemr.reporting.library.shared.tb.TbCohortLibrary;
import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.openmrs.module.kenyacore.report.ReportUtils.map;
import static org.openmrs.module.kenyaemr.reporting.EmrReportingUtils.cohortIndicator;

/**
 * Library of Quality Improvement indicators for HIV care. All indicators require parameter ${endDate}
 */
@Component
public class QiIndicatorLibrary {

	@Autowired
	private HivCohortLibrary hivCohorts;

	@Autowired
	private ArtCohortLibrary artCohorts;

	@Autowired
	private QiCohortLibrary qiCohorts;

	@Autowired
	private TbCohortLibrary tbCohorts;

	/**
	 * Percentage of patients with an HIV care visit who have CD4 test results in the last 6 months
	 * @return the indicator
	 */
	public CohortIndicator hivMonitoringCd4() {
		return cohortIndicator("HIV monitoring - CD4",
				map(hivCohorts.hasCd4Result(), "onOrAfter=${endDate-6m},onOrBefore=${endDate}"),
				map(hivCohorts.hasHivVisit(), "onOrAfter=${endDate-6m},onOrBefore=${endDate}")
		);
	}

	/**
	 * Percentage of patients who had a nutritional assessment in their last visit
	 * @return the indicator
	 */
	public CohortIndicator nutritionalAssessment() {
		return cohortIndicator("Nutritional assessment",
				map(qiCohorts.hadNutritionalAssessmentAtLastVisit(), "onOrBefore=${endDate}"),
				map(hivCohorts.hasHivVisit(), "onOrAfter=${endDate-6m},onOrBefore=${endDate}")
		);
	}

	/**
	 * Percentage eligible patients initiated on ART
	 * @return the indicator
	 */
	public CohortIndicator artInitiation() {
		return cohortIndicator("ART Initiation",
				map(artCohorts.startedArt(), "onOrAfter=${endDate-6m},onOrBefore=${endDate}" ),
				map(qiCohorts.hivInfectedAndNotOnARTAndHasHivClinicalVisit(), "onOrAfter=${startDate}" )
				);
	}

	/**
	 * Clinical visit service coverage
	 * @return the indicator
	 */
	public CohortIndicator clinicalVisit() {
		return cohortIndicator("Clinical Visit",
				map(qiCohorts.inCareHasAtLeast2Visits(), "onDate=${endDate-6m}" ),
				map(qiCohorts.clinicalVisit(), "onOrAfter=${startDate},onOrBefore=${endDate}" )
		);
	}

	/**
	 * HIV Monitoring Viral Load coverage
	 * @return the indicator
	 */
	public CohortIndicator hivMonitoringViralLoad() {
		return cohortIndicator("HIV Monitoring - Viral Load",
				map(qiCohorts.onARTatLeast12MonthsAndHaveAtLeastVLResultsDuringTheLast12Months(), "onOrBefore=${endDate}" ),
				map(qiCohorts.onARTatLeast12MonthsAndHaveAtLeastOneVisitDuringTheLast6MonthsReview(), "onOrAfter=${startDate},onOrBefore=${endDate}" )
		);
	}

	/**
	 * HIV Monitoring Viral Load - supression outcome
	 * @return CohortIndicator
	 */
	public CohortIndicator hivMonitoringViralLoadSupression() {
		return cohortIndicator("HIV Monitoring - Viral Load - Supression Outcome",
				map(qiCohorts.onARTatLeast12MonthsAndVlLess1000(), "onOrBefore=${endDate}" ),
				map(qiCohorts.onARTatLeast12MonthsAndAtLeastVlResults(), "onOrBefore=${endDate}" )
		);
	}

	/**
	 * Tb Screening Servicess coverage
	 * @return CohortIndicator
	 */
	public CohortIndicator tbScreeningServiceCoverage() {
		return cohortIndicator("Tb screening - Service Coverage",
				map(tbCohorts.screenedForTb(), "onOrAfter=${endDate-6m},onOrBefore=${endDate}"),
				map(qiCohorts.hivInfectedNotOnTbTreatmentHaveAtLeastOneHivClinicalVisitDuring6Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}
}