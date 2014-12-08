package uk.ac.ebi.pride.archive.wsclient.client.project;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.client.ArchiveClient;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.project.ProjectDetails;
import uk.ac.ebi.pride.archive.wsclient.model.projectsummary.ProjectSummaryList;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ypriverol
 */
public class ProjectWsClient extends ArchiveClient{

    /**
     * Default constructor for Archive clients
     *
     * @param config
     */
    public ProjectWsClient(AbstractArchiveWsConfig config) {
        super(config);
    }

    /**
     * Retrieve the information for a particular query trough all the fields
     * @return
     * @throws java.io.IOException
     */
    public ProjectDetails getProject(String accession) throws IOException {

        String url = String.format("%s://%s/pride/ws/archive/project/%s",
                config.getProtocol(), config.getHostName(), accession);

        return this.restTemplate.getForObject(url, ProjectDetails.class);

    }

}
