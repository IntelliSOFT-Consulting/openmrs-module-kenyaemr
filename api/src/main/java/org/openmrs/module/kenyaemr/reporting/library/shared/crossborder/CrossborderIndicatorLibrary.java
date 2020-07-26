/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.kenyaemr.reporting.library.shared.crossborder;

import static org.openmrs.module.kenyacore.report.ReportUtils.map;
import static org.openmrs.module.kenyaemr.reporting.EmrReportingUtils.cohortIndicator;

import org.openmrs.module.reporting.indicator.CohortIndicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Library of TB related indicator definitions. All indicators require parameters ${startDate} and ${endDate}
 */
@Component
public class CrossborderIndicatorLibrary {

	@Autowired
	private CrossborderCohortLibrary crossborderCohorts;

	/**
	 * Number of patients screened for TB
	 * @return the indicator
	 */
	public CohortIndicator screenedForTb() {
		return cohortIndicator("patients screened for TB",
				map(crossborderCohorts.screenedForTbAndHivPositive(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Number of patients who died and started TB treatment 12 months ago
	 * @return the indicator
	 */
	public CohortIndicator diedAndStarted12MonthsAgo() {
		return cohortIndicator("patients who started TB treatment 12 months ago and died",
				map(crossborderCohorts.diedAndStarted12MonthsAgo(), "onOrBefore=${endDate}")
		);
	}

	/**
	 * Number of patients who completed Tb Treatment and are in Tb program
	 * @return the indicator
	 */
	public CohortIndicator completedTbTreatment() {
		return cohortIndicator("patients who completed TB treatment",
				map(crossborderCohorts.completedTreatment(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}


	/**
	 * Number of patients who defaulted
	 * @return the indicator
	 */
	public CohortIndicator defaulted() {
		return cohortIndicator("patients who defaulted", map(crossborderCohorts.defaulted(), "onDate=${endDate}"));
	}

	/**
	 * Number of patients in Tb and HIV programs who are taking CTX prophylaxis
	 * @return the indicator
	 */
	public CohortIndicator inTbAndHivProgramsAndOnCtxProphylaxis() {
		return cohortIndicator("in TB and HIV programs and on CTX prophylaxis",
				map(crossborderCohorts.inTbAndHivProgramsAndOnCtxProphylaxis(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Number of patients in Tb and are HIV tested
	 * @return the indicator
	 */
	public CohortIndicator inTbAndTestedForHiv() {
		return cohortIndicator("in TB program and tested for HIV",
				map(crossborderCohorts.testedForHivAndInTbProgram(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Number of patients in Tb and are HIV tested and their result is positive
	 * @return the indicator
	 */
	public CohortIndicator inTbAndTestedForHivPositive() {
		return cohortIndicator("in TB program and tested positive for HIV",
				map(crossborderCohorts.testedHivPositiveAndInTbProgram(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Number of patients with Tb retreatments
	 * @return the indicator
	 */
	public CohortIndicator tbRetreatmentsPatients() {
		return cohortIndicator("TB re-treatment patients",
				map(crossborderCohorts.tbRetreatments(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Number of patients with Extra pulmonary Tb
	 * @return the indicator
	 */
	public CohortIndicator extraPulmonaryTbPatients() {
		return cohortIndicator("patients with extra pulmonary TB",
				map(crossborderCohorts.extraPulmonaryTbPatients(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Number of pulmonary TB patients with smear negative results
	 * @return the indicator
	 */
	public CohortIndicator pulmonaryTbSmearNegative() {
		return cohortIndicator("patients with pulmonary TB smear negative results",
				map(crossborderCohorts.pulmonaryTbSmearNegative(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Number of pulmonary TB patients with smear positive results
	 * @return the indicator
	 */
	public CohortIndicator pulmonaryTbSmearPositive() {
		return cohortIndicator("patients with pulmonary TB smear positive results",
				map(crossborderCohorts.pulmonaryTbSmearPositive(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Patients with new Tb detected cases
	 * @return the indicator
	 */
	public CohortIndicator tbNewDetectedCases() {
		return cohortIndicator("new TB cases detected",
				map(crossborderCohorts.tbNewDetectedCases(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total enrolled patients into tb program and have ptb smear not done results at 2 months
	 * @return cohort indicator
	 */
	public CohortIndicator totalEnrolled() {
		return cohortIndicator("TB - Total Enrolled",
				map(crossborderCohorts.totalEnrolledPtbSmearNotDoneResultsAtMonths(12, 8), "onOrAfter=${startDate},onOrBefore=${endDate}")
				);
	}

	/**
	 * Total patients who finalized their treatment
	 * @return Indicator
	 */
	public  CohortIndicator finalizedInitialTreatment() {
		return cohortIndicator("TB - Finalized Initial Treatment",
				map(crossborderCohorts.ptbSmearNotDoneResults2MonthsFinalizedInitialtreatment(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total patients who died
	 * @return Indicator
	 */
	public  CohortIndicator died() {
		return cohortIndicator("Died",
				map(crossborderCohorts.ptbSmearNotDoneResults2MonthsDied(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total patients who died
	 * @return Indicator
	 */
	public  CohortIndicator absconded() {
		return cohortIndicator("Absconded",
				map(crossborderCohorts.ptbSmearNotDoneResults2MonthsAbsconded(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total patients who Transferred out
	 * @return Indicator
	 */
	public  CohortIndicator transferredOut() {
		return cohortIndicator("Transferred Out",
				map(crossborderCohorts.ptbSmearNotDoneResults2MonthsTransferredOut(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total patients evaluated
	 * @return Indicator
	 */
	public  CohortIndicator totalEvaluated() {
		return cohortIndicator("Total evaluated",
				map(crossborderCohorts.ptbSmearNotDoneResults2MonthsTotalEvaluated(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator totalEnrolled8MonthsHivPositive() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive",
				map(crossborderCohorts.totalEnrolled8MonthsHivPositive(), "onOrAfter=${startDate},onOrBefore=${endDate}")
				);
	}

	/**
	 * Total number of patients enrollment
	 * hiv negative
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator totalEnrolled8MonthsHivNegative() {
		return cohortIndicator("Total Enrolled 8 months HIV Negative",
				map(crossborderCohorts.totalEnrolled8MonthsHivNegative(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator totalEnrolled8MonthsHivTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test NOT done",
				map(crossborderCohorts.totalEnrolled8MonthsHivTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done, hiv+, hiv-
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator totalEnrolled8MonthsHivPositiveNegativeTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test NOT done hiv pos,neg",
				map(crossborderCohorts.totalEnrolled8MonthsHivPositiveNegativeTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on cpt
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator totalEnrolled8MonthsHivPositiveOnCpt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on cpt",
				map(crossborderCohorts.totalEnrolled8MonthsHivPositiveOnCpt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on art
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator totalEnrolled8MonthsHivPositiveOnArt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on art",
				map(crossborderCohorts.totalEnrolled8MonthsHivPositiveOnArt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV positive
	 * completed the treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentResults8monthsHivPositive() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and finalized initial treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentResults8monthsHivPositive(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV positive
	 * died
	 * @return Indicator
	 */
	public CohortIndicator diedResults8monthsHivPositive() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and Died ",
				map(crossborderCohorts.diedResults8monthsHivPositive(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV positive
	 * absconded
	 * @return Indicator
	 */
	public CohortIndicator abscondedResults8monthsHivPositive() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and Absconded ",
				map(crossborderCohorts.abscondedResults8monthsHivPositive(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV positive
	 * Transferred out
	 * @return Indicator
	 */
	public CohortIndicator transferredOutResults8monthsHivPositive() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and Transferred Out ",
				map(crossborderCohorts.transferredOutResults8monthsHivPositive(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV positive
	 * Transferred out, absconded, died, finished initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivPositive() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and Transferred out, absconded, died, finished initial treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivPositive(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV negative
	 * finished initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentTotalEnrolled8MonthsHivNegative() {
		return cohortIndicator("Total Enrolled 8 months HIV Negative and finished initial treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentTotalEnrolled8MonthsHivNegative(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV negative
	 * died
	 * @return Indicator
	 */
	public CohortIndicator diedTotalEnrolled8MonthsHivNegative() {
		return cohortIndicator("Total Enrolled 8 months HIV Negative and died ",
				map(crossborderCohorts.diedTotalEnrolled8MonthsHivNegative(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV negative
	 * absconded
	 * @return Indicator
	 */
	public CohortIndicator abscondedTotalEnrolled8MonthsHivNegative() {
		return cohortIndicator("Total Enrolled 8 months HIV Negative and absconded ",
				map(crossborderCohorts.abscondedTotalEnrolled8MonthsHivNegative(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV negative
	 * Transferred out
	 * @return Indicator
	 */
	public CohortIndicator transferredOutTotalEnrolled8MonthsHivNegative() {
		return cohortIndicator("Total Enrolled 8 months HIV Negative and transferred out ",
				map(crossborderCohorts.transferredOutTotalEnrolled8MonthsHivNegative(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV negative
	 * Transferred out, absconded, died, finished initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivNegative() {
		return cohortIndicator("Total Enrolled 8 months HIV Negative and Transferred out, absconded, died, finished initial treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivNegative(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done
	 * results 8 months
	 * 8-12 months earlier
	 * completed initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finishedInitialTreatmentTotalEnrolled8MonthsHivTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test NOT done and finished initial treatment",
				map(crossborderCohorts.finalizedInitialTreatmentTotalEnrolled8MonthsHivTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done
	 * results 8 months
	 * 8-12 months earlier
	 * died
	 * @return Indicator
	 */
	public CohortIndicator diedTotalEnrolled8MonthsHivTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test NOT done and died",
				map(crossborderCohorts.diedTotalEnrolled8MonthsHivTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done
	 * results 8 months
	 * 8-12 months earlier
	 * absconded
	 * @return Indicator
	 */
	public CohortIndicator abscondedTotalEnrolled8MonthsHivTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test NOT done and absconded",
				map(crossborderCohorts.abscondedTotalEnrolled8MonthsHivTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done
	 * results 8 months
	 * 8-12 months earlier
	 * transferred out
	 * @return Indicator
	 */
	public CohortIndicator transferredOutTotalEnrolled8MonthsHivTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test NOT done and transferred out",
				map(crossborderCohorts.transferredOutTotalEnrolled8MonthsHivTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV test not done
	 * Transferred out, absconded, died, finished initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test not done and Transferred out, absconded, died, finished initial treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done, hiv+, hiv-
	 * completed initial treatment
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentTotalEnrolled8MonthsHivPositiveNegativeTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test total and hiv pos,neg completed treatment",
				map(crossborderCohorts.finalizedInitialTreatmentTotalEnrolled8MonthsHivPositiveNegativeTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done, hiv+, hiv-
	 * died
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator diedTotalEnrolled8MonthsHivPositiveNegativeTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test total and hiv pos,neg and died",
				map(crossborderCohorts.diedTotalEnrolled8MonthsHivPositiveNegativeTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done, hiv+, hiv-
	 * absconded
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator abscondedTotalEnrolled8MonthsHivPositiveNegativeTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test total and hiv pos,neg and absconded",
				map(crossborderCohorts.abscondedTotalEnrolled8MonthsHivPositiveNegativeTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv test not done, hiv+, hiv-
	 * transferred out
	 * results 8 months
	 * 8-12 months earlier
	 * @return Indicator
	 */
	public CohortIndicator transferredOutTotalEnrolled8MonthsHivPositiveNegativeTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test total and hiv pos,neg and transferred out",
				map(crossborderCohorts.transferredOutTotalEnrolled8MonthsHivPositiveNegativeTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV test totals
	 * Transferred out, absconded, died, finished initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivPositiveNegativeTestNotDone() {
		return cohortIndicator("Total Enrolled 8 months HIV test total and Transferred out, absconded, died, finished initial treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivPositiveNegativeTestNotDone(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on cpt
	 * results 8 months
	 * 8-12 months earlier
	 * finalized initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizeInitialTreatmentTotalEnrolled8MonthsHivPositiveOnCpt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on cpt and finalized initial treatment",
				map(crossborderCohorts.finalizedInitialTreatmentTotalEnrolled8MonthsHivPositiveOnCpt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on cpt
	 * results 8 months
	 * 8-12 months earlier
	 * died
	 * @return Indicator
	 */
	public CohortIndicator diedTotalEnrolled8MonthsHivPositiveOnCpt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on cpt and died",
				map(crossborderCohorts.diedTotalEnrolled8MonthsHivPositiveOnCpt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on cpt
	 * results 8 months
	 * 8-12 months earlier
	 * absconded
	 * @return Indicator
	 */
	public CohortIndicator abscondedTotalEnrolled8MonthsHivPositiveOnCpt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on cpt and absconded",
				map(crossborderCohorts.abscondedTotalEnrolled8MonthsHivPositiveOnCpt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on cpt
	 * results 8 months
	 * 8-12 months earlier
	 * transferred out
	 * @return Indicator
	 */
	public CohortIndicator transferredOutTotalEnrolled8MonthsHivPositiveOnCpt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on cpt and transfer out",
				map(crossborderCohorts.transferredOutTotalEnrolled8MonthsHivPositiveOnCpt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV positive
	 * Transferred out, absconded, died, finished initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivPositiveOnCpt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on cpt and Transferred out, absconded, died, finished initial treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivPositiveOnCpt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on art
	 * results 8 months
	 * 8-12 months earlier
	 * finalized initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentTotalEnrolled8MonthsHivPositiveOnArt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on art and finalized initial treatment",
				map(crossborderCohorts.finalizedInitialTreatmentTotalEnrolled8MonthsHivPositiveOnArt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on art
	 * results 8 months
	 * 8-12 months earlier
	 * died
	 * @return Indicator
	 */
	public CohortIndicator diedTotalEnrolled8MonthsHivPositiveOnArt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on art and died",
				map(crossborderCohorts.diedTotalEnrolled8MonthsHivPositiveOnArt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on art
	 * results 8 months
	 * 8-12 months earlier
	 * absconded
	 * @return Indicator
	 */
	public CohortIndicator abscondedTotalEnrolled8MonthsHivPositiveOnArt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on art and absconded",
				map(crossborderCohorts.abscondedTotalEnrolled8MonthsHivPositiveOnArt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Total number of patients enrollment
	 * hiv positive
	 * on art
	 * results 8 months
	 * 8-12 months earlier
	 * absconded
	 * @return Indicator
	 */
	public CohortIndicator transferredOutTotalEnrolled8MonthsHivPositiveOnArt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on art and transferred out",
				map(crossborderCohorts.transferOutTotalEnrolled8MonthsHivPositiveOnArt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Patients who finalized initial treatment
	 * Results at 8 months
	 * 8-12 months earlier
	 * HIV positive
	 * Transferred out, absconded, died, finished initial treatment
	 * on art
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivPositiveOnArt() {
		return cohortIndicator("Total Enrolled 8 months HIV Positive and on art and Transferred out, absconded, died, finished initial treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentDiedAbscondedTransferredOutResults8monthsHivPositiveOnArt(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 2 months
	 * @return Indicator
	 */
	public CohortIndicator newSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months() {
		return cohortIndicator("Total Enrolled 2 months results new smear negative PTB ",
				map(crossborderCohorts.newSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months(15, 12), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 2 months
	 * finalized treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months() {
		return cohortIndicator("Total Enrolled 2 months results new smear negative PTB - Finalized Initial Treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 2 months
	 * died
	 * @return Indicator
	 */
	public CohortIndicator diedNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months() {
		return cohortIndicator("Total Enrolled 2 months results new smear negative PTB - Died",
				map(crossborderCohorts.diedNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 2 months
	 * absconded
	 * @return Indicator
	 */
	public CohortIndicator abscondedNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months() {
		return cohortIndicator("Total Enrolled 2 months results new smear negative PTB - Absconded",
				map(crossborderCohorts.abscondedNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 2 months
	 * transferred out
	 * @return Indicator
	 */
	public CohortIndicator transferredOutNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months() {
		return cohortIndicator("Total Enrolled 2 months results new smear negative PTB - Transferred Out",
				map(crossborderCohorts.transferOutNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 2 months
	 * transferred out, absconded, died, finalized initial treatment
	 * @return Indicator
	 */
	public CohortIndicator transferOutAbscondedDiedFinalizedInitialTreatmentNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months() {
		return cohortIndicator("Total Enrolled 2 months results new smear negative PTB - All Outcomes",
				map(crossborderCohorts.transferOutAbscondedDiedFinalizedInitialTreatmentNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults2Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 8 months
	 * @return Indicator
	 */
	public CohortIndicator newSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months() {
		return cohortIndicator("Total Enrolled 8 months results new smear negative PTB ",
				map(crossborderCohorts.newSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months(15, 12), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 8 months
	 * treatment complete
	 * @return Indicator
	 */
	public CohortIndicator treatmentCompletedNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months() {
		return cohortIndicator("Total Enrolled 8 months results new smear negative PTB - Treatment Complete ",
				map(crossborderCohorts.treatmentCompletedNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 8 months
	 * died
	 * @return Indicator
	 */
	public CohortIndicator diedNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months() {
		return cohortIndicator("Total Enrolled 8 months results new smear negative PTB - Died ",
				map(crossborderCohorts.diedNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 8 months
	 * out of control
	 * @return Indicator
	 */
	public CohortIndicator outOfControlNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months() {
		return cohortIndicator("Total Enrolled 8 months results new smear negative PTB - Out Of Control ",
				map(crossborderCohorts.outOfControlNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 8 months
	 * transferred out
	 * @return Indicator
	 */
	public CohortIndicator transferOutNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months() {
		return cohortIndicator("Total Enrolled 8 months results new smear negative PTB - Transferred Out ",
				map(crossborderCohorts.transferOutNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 8 months
	 * became smear positive
	 * @return Indicator
	 */
	public CohortIndicator becameSmearPositiveNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months() {
		return cohortIndicator("Total Enrolled 8 months results new smear negative PTB - Transferred Out ",
				map(crossborderCohorts.becameSmearPositiveNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * Treatment of new sputum smear negative pulmonary
	 * patients registered 12 to 15 months earlier
	 * pulmonary tb
	 * results at 8 months
	 * became smear positive,transferred out,out of control,treatment complete, died
	 * @return Indicator
	 */
	public CohortIndicator transferOutOutOfControlDiedCompletedTreatmentNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months() {
		return cohortIndicator("Total Enrolled 8 months results new smear negative PTB - Outcomes all ",
				map(crossborderCohorts.transferOutOutOfControlDiedCompletedTreatmentNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}


	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 2 months
	 * @return Indicator
	 */
	public CohortIndicator extraPulmonaryTbResultsAt2Months() {
		return cohortIndicator("Total Enrolled 2 months results Extra-Pulmonary TB ",
				map(crossborderCohorts.extraPulmonaryTbResultsAt2Months(15, 12), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 2 months
	 * finalized initial treatment
	 * @return Indicator
	 */
	public CohortIndicator finalizedInitialTreatmentExtraPulmonaryTbResultsAt2Months() {
		return cohortIndicator("Total Enrolled 2 months results Extra-Pulmonary TB - Finalized Initial Treatment ",
				map(crossborderCohorts.finalizedInitialTreatmentExtraPulmonaryTbResultsAt2Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 2 months
	 * died
	 * @return Indicator
	 */
	public CohortIndicator diedExtraPulmonaryTbResultsAt2Months() {
		return cohortIndicator("Total Enrolled 2 months results Extra-Pulmonary TB - Died ",
				map(crossborderCohorts.diedExtraPulmonaryTbResultsAt2Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 2 months
	 * absconded
	 * @return Indicator
	 */
	public CohortIndicator abscondedExtraPulmonaryTbResultsAt2Months() {
		return cohortIndicator("Total Enrolled 2 months results Extra-Pulmonary TB - Absconded ",
				map(crossborderCohorts.abscondedExtraPulmonaryTbResultsAt2Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 2 months
	 * absconded
	 * @return Indicator
	 */
	public CohortIndicator transferredOutExtraPulmonaryTbResultsAt2Months() {
		return cohortIndicator("Total Enrolled 2 months results Extra-Pulmonary TB - Transferred Out ",
				map(crossborderCohorts.transferredOutExtraPulmonaryTbResultsAt2Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 2 months
	 * all outcomes
	 * @return Indicator
	 */
	public CohortIndicator transferOutAbscondedDiedCompletedTreatmentNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months() {
		return cohortIndicator("Total Enrolled 2 months results Extra-Pulmonary TB - Outcomes all ",
				map(crossborderCohorts.transferOutAbscondedDiedCompletedTreatmentNewSputumSmearNegative12to15MonthsEarlierPulmonaryTbResults8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 8 months
	 * @return Indicator
	 */
	public CohortIndicator extraPulmonaryTbResultsAt8Months() {
		return cohortIndicator("Total Enrolled 8 months results Extra-Pulmonary TB ",
				map(crossborderCohorts.extraPulmonaryTbResultsAt8Months(15, 12), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 8 months
	 * treatment completed
	 * @return Indicator
	 */
	public CohortIndicator treatmentCompletedExtraPulmonaryTbResultsAt8Months() {
		return cohortIndicator("Total Enrolled 8 months results Extra-Pulmonary TB - Treatment Complete ",
				map(crossborderCohorts.treatmentCompleteExtraPulmonaryTbResultsAt8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 8 months
	 * died
	 * @return Indicator
	 */
	public CohortIndicator diedExtraPulmonaryTbResultsAt8Months() {
		return cohortIndicator("Total Enrolled 8 months results Extra-Pulmonary TB - Died",
				map(crossborderCohorts.diedExtraPulmonaryTbResultsAt8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 8 months
	 * out of control
	 * @return Indicator
	 */
	public CohortIndicator outOfControlExtraPulmonaryTbResultsAt8Months() {
		return cohortIndicator("Total Enrolled 8 months results Extra-Pulmonary TB - Out of Control",
				map(crossborderCohorts.outOfControlExtraPulmonaryTbResultsAt8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 8 months
	 * transferred out
	 * @return Indicator
	 */
	public CohortIndicator transferredOutExtraPulmonaryTbResultsAt8Months() {
		return cohortIndicator("Total Enrolled 8 months results Extra-Pulmonary TB - Transferred Out",
				map(crossborderCohorts.transferredOutExtraPulmonaryTbResultsAt8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	/**
	 * patients registered 12 to 15 months earlier
	 * extra pulmonary TB
	 * results at 8 months
	 * outcomes all
	 * @return Indicator
	 */
	public CohortIndicator transferOutOutOfControlDiedCompletedTreatmentExtraPulmonaryTbResultsAt8Months() {
		return cohortIndicator("Total Enrolled 8 months results Extra-Pulmonary TB - Outcomes all",
				map(crossborderCohorts.transferOutOutOfControlDiedCompletedTreatmentExtraPulmonaryTbResultsAt8Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator cbOtherNationalities() {
		return cohortIndicator("Number of other nationalities accessing specified services",
			map(crossborderCohorts.cbOtherNationalities(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}
	
	public CohortIndicator cbResidentOtherCounties() {
		return cohortIndicator("Number of residents of other districts/counties accessing services at the border facility",
			map(crossborderCohorts.cbResidentOtherCounties(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}
	
	public CohortIndicator cbTravelledOtherCountry() {
		return cohortIndicator("Number reporting travelled to another country last 3/6/12 months",
			map(crossborderCohorts.cbTravelledOtherCountry(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator receivedHivTestResults() {
		return cohortIndicator("TXT-HTS: # of individuals who received HIV testing services (HTS) and received their test results, disaggregated by HIV result",
			map(crossborderCohorts.cbReceivedHivTestResults(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator initiatedOnTreatment() {
		return cohortIndicator("TX-New:# of individuals newly initiated on Treatment",
			map(crossborderCohorts.initiatedOnTreatment(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator testedHivPositive() {
		return cohortIndicator("TX-POS: # of individuals who tested HIV positive",
			map(crossborderCohorts.testedHivPositive(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator returnVisits() {
		return cohortIndicator("TX-SV:  who returned for second visit",
			map(crossborderCohorts.returnVisits(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator receivingTreatment() {
		return cohortIndicator("TX-CURR: of adults and children currently receiving ART",
			map(crossborderCohorts.receivingTreatment(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator virallySuppressed() {
		return cohortIndicator("TX-PLVS: % of ART patients with a viral load result documented in the medical record and/or laboratory information systems (LIS) within the past 12 months with a suppressed viral load (<400 copies/ml)",
			map(crossborderCohorts.virallySuppressed(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator retainedOnTreatmentAfterOneMonth() {
		return cohortIndicator("% of adults and children known to be on treatment 1 months after initiation of ART",
			map(crossborderCohorts.retainedOnTreatmentAfterOneMonth(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator retainedOnTreatmentAfter6Months() {
		return cohortIndicator("% of adults and children known to be on treatment 6 months after initiation of ART",
			map(crossborderCohorts.retainedOnTreatmentAfter6Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator retainedOnTreatmentAfter3Months() {
		return cohortIndicator("% of adults and children known to be on treatment 3 months after initiation of ART",
			map(crossborderCohorts.retainedOnTreatmentAfter3Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

	public CohortIndicator retainedOnTreatmentAfter12Months() {
		return cohortIndicator("% of adults and children known to be on treatment 12 months after initiation of ART",
			map(crossborderCohorts.retainedOnTreatmentAfter12Months(), "onOrAfter=${startDate},onOrBefore=${endDate}")
		);
	}

}