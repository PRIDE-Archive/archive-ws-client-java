package uk.ac.ebi.pride.archive.web.service.model.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import uk.ac.ebi.pride.archive.web.service.model.common.ContactDetail;

/**
 * @author ypriverol
 * @author jadianes
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class ProjectDetails {

    @JsonProperty("accession")        // project's accession number,
    public String accession;

    @JsonProperty("submitter")
    public ContactDetail submitter;  // details of the submitter of the dataset

    @JsonProperty("keywords")
    public String keywords;           //relevant keywords associated with the project

    @JsonProperty("doi")
    public String doi;                // the Digital Object Identifier (DOI) for the project (if available)

    @JsonProperty("reanalysis")
    public String reanalysis;         // annotation to indicate that the dataset is a re-analysis based on other public data

    @JsonProperty("experimentTypes")
    public String[] experimentTypes;  // the type(s) of experiment preformed

    @JsonProperty("submissionDate")
    public String submissionDate;     //the date the project has been submitted,

    @JsonProperty("labHeads")
    public ContactDetail[] labHeads;  // the Lab-Head or PI associated to the dataset,

    @JsonProperty("sampleProcessingProtocol")
    public String sampleProcessingProtocol;  //meta-data: information about the sample processing,

    @JsonProperty("dataProcessingProtocol")
    public String dataProcessingProtocol;    // project meta-data: information about the data processing

    @JsonProperty("otherOmicsLink")
    public String  otherOmicsLink;           // links to other datasets related to this project (if available),

    @JsonProperty("quantificationMethods")
    public String[] quantificationMethods;   // the quantification method(s) used with the dataset (if any),

    @JsonProperty("numProteins")
    public int  numProteins;                 // number of reported proteins,

    @JsonProperty("numIdentifiedSpectra")
    public int numIdentifiedSpectra;         // project statistics: number of identified spectra,

    @JsonProperty("numPeptides")             // project statistics: number of reported peptides.
    public int numPeptides;

    @JsonProperty("numUniquePeptides")
    public int numUniquePeptides;            // number of unique peptides

    @JsonProperty("numSpectra")
    public int numSpectra;                   //  number of spectra,

    @JsonProperty("species")
    public String[] species;                 // the species annotation for the project,

    @JsonProperty("tissues")
    public String[] tissues;                 // the tissue annotation for the project,

    @JsonProperty("title")
    public String title;                     // the title given to the project,

    @JsonProperty("publicationDate")
    public String publicationDate;           // the date the project has been made public,

    @JsonProperty("ptmNames")
    public String[] ptmNames;                // the Post Translational Modifications (PTM) annotated for the project,

    @JsonProperty("projectDescription")
    public String projectDescription;        // the description provided for the project

    @JsonProperty("numAssays")
    public int numAssays;                // the number of assays associated with this project,


    @JsonProperty("submissionType")
    public String submissionType;            // the type of submission (complete or partial),

    @JsonProperty("projectTags")
    public String[] projectTags;

    @JsonProperty("instrumentNames")
    public String[] instrumentNames;          //the instrument annotation for the project
}
