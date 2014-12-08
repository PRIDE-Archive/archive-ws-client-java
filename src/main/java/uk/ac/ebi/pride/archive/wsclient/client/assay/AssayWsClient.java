package uk.ac.ebi.pride.archive.wsclient.client.assay;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.client.ArchiveClient;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.assay.AssayDetail;

/**
 * @author ypriverol
 */
public class AssayWsClient  extends ArchiveClient{


    /**
     * Default constructor for Archive clients
     *
     * @param config
     */
    public AssayWsClient(AbstractArchiveWsConfig config) {
        super(config);
    }

    /**
     * Returns the assay details for an specific assayAccession
     * @param assayAccession Assay Accession
     * @return The Assay information
     */
    public AssayDetail getAssayByAccession(String assayAccession){

        String url = String.format("%s://%s/pride/ws/archive/assay/%s",
                config.getProtocol(), config.getHostName(), assayAccession);


        return this.restTemplate.getForObject(url, AssayDetail.class);
    }
}
