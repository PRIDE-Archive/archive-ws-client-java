package uk.ac.ebi.pride.archive.wsclient.client.assay;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.client.ArchiveClient;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.assay.AssayList;

/**
 * @author ypriverol
 */
public class ProjectAssaysWsClient extends ArchiveClient{


    /**
     * Default constructor for Archive clients
     *
     * @param config
     */
    public ProjectAssaysWsClient(AbstractArchiveWsConfig config) {
        super(config);
    }

    /**
     * Return a lis of Assays for an Specific Project Accession
     * @param projectAccession
     * @return
     */
    public AssayList findAllByProjectAccession(String projectAccession){

       String url = String.format("%s://%s/pride/ws/archive/assay/list/project/%s",
                config.getProtocol(), config.getHostName(), projectAccession);

        return this.restTemplate.getForObject(url, AssayList.class);
    }
}
