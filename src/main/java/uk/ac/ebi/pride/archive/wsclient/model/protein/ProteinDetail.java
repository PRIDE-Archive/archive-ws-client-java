package uk.ac.ebi.pride.archive.wsclient.model.protein;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ypriverol
 */
public class ProteinDetail {

    @JsonProperty("accession")
    public String accession;       //the submitted accession of the identified protein,

    @JsonProperty("projectAccession")
    public String projectAccession;    //the project that identified the protein,

    @JsonProperty("assayAccession")
    public String assayAccession;      // the assay within the project that identified the protein,

    synonyms (array[string], optional): accession synonyms; either UniProt accession or EnsEMBL ID,
    sequenceType (string, optional) = ['INFERRED' or 'SUBMITTED' or 'NOT_AVAILABLE']: SUBMITTED (provided with dataset) or INFERRED (inferred by PRIDE based on protein accession),
    description (array[string], optional): a description of the protein (usually inferred from protein accession),
    sequence (string, optional): the AA sequence of the identified protein (may be inferred from protein accession)
}
