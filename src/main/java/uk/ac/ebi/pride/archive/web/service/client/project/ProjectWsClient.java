package uk.ac.ebi.pride.archive.web.service.client.project;

import uk.ac.ebi.pride.archive.web.service.model.project.ProjectDetails;
import uk.ac.ebi.pride.archive.web.service.client.ArchiveClient;
import uk.ac.ebi.pride.archive.web.service.config.AbstractArchiveWsConfig;

import java.io.IOException;

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
