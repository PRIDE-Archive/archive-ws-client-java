package uk.ac.ebi.pride.archive.wsclient.model.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jadianes
 * @author ypriverol
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class ProjectDetails {

    @JsonProperty("accession")
    String submitter;  (ContactDetail, optional): details of the submitter of the dataset,
                keywords (string, optional): relevant keywords associated with the project,
        doi (string, optional): the Digital Object Identifier (DOI) for the project (if available),
        reanalysis (string, optional): annotation to indicate that the dataset is a re-analysis based on other public data,
        experimentTypes (array[string], optional): the type(s) of experiment preformed,
        submissionDate (date-time, optional): the date the project has been submitted,
                labHeads (array[ContactDetail], optional): the Lab-Head or PI associated to the dataset,
        sampleProcessingProtocol (string, optional): roject meta-data: information about the sample processing,
                dataProcessingProtocol (string, optional): project meta-data: information about the data processing,
                otherOmicsLink (string, optional): links to other datasets related to this project (if available),
        quantificationMethods (array[string], optional): the quantification method(s) used with the dataset (if any),
        numProteins (integer, optional): project statistics: number of reported proteins,
        numIdentifiedSpectra (integer, optional): project statistics: number of identified spectra,
        numPeptides (integer, optional): project statistics: number of reported peptides,
        numUniquePeptides (integer, optional): project statistics: number of unique peptides,
        numSpectra (integer, optional): project statistics: number of spectra,
                accession (string, optional): the project's accession number,
        species (array[string], optional): the species annotation for the project,
        tissues (array[string], optional): the tissue annotation for the project,
        title (string, optional): the title given to the project,
        publicationDate (date-time, optional): the date the project has been made public,
        ptmNames (array[string], optional): the Post Translational Modifications (PTM) annotated for the project,
        projectDescription (string, optional): the description provided for the project,
        numAssays (integer, optional): the number of assays associated with this project,
                submissionType (string, optional): the type of submission (complete or partial),
        projectTags (array[string], optional): specific tags added to the project for classification,
                instrumentNames (array[string], optional): the instrument annotation for the project
}
