package uk.ac.ebi.pride.archive.wsclient.client.assay;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;


/**
 * @author ypriverol
 */
public class AssayCountWsClient {

    protected RestTemplate restTemplate;
    protected AbstractArchiveWsConfig config;

    /**
     * Constructor
     * @param restTemplate
     * @param config
     */
    public AssayCountWsClient(RestTemplate restTemplate, AbstractArchiveWsConfig config) {
        this.restTemplate = restTemplate;
        this.config = config;
    }

    /**
     * Count number of Assays by Projects
     * @param projectAccession
     * @return
     */
    public int countByProjectAccession(String projectAccession){

        String url = String.format("%s://%s/pride/ws/archive/assay/count/%s",
                config.getProtocol(), config.getHostName(), projectAccession);


        return this.restTemplate.getForObject(url, Integer.class);
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AbstractArchiveWsConfig getConfig() {
        return config;
    }

    public void setConfig(AbstractArchiveWsConfig config) {
        this.config = config;
    }
}
