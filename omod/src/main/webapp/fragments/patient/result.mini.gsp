<img ng-src="${ ui.resourceLink("kenyaui", "images/glyphs/patient_") }{{ patient.gender.toLowerCase() }}.png" class="ke-glyph" />
{{ patient.givenName }} {{ patient.familyName }} <span style="color: #999">{{ patient.age }}</span>
<div ng-repeat="identifier in patient.identifiers">{{ identifier.name }}: {{ identifier.value }} </div>
<div ng-if="patient.mpiPatient"><a href="#"  ng-click="onMpiImportClick(\$event, patient)">Import from MPI</a></div>