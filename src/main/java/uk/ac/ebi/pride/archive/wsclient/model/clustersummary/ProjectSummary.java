package uk.ac.ebi.pride.archive.wsclient.model.clustersummary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jadianes ${EMAIL}
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectSummary {

    @JsonProperty("accession")
    public String accession;

    @JsonProperty("title")
    public String title;

}
