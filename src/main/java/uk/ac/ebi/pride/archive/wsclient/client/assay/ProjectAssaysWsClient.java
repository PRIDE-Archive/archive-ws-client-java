package uk.ac.ebi.pride.archive.wsclient.client.assay;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.assay.AssayList;

/**
 * @author ypriverol
 */
public class ProjectAssaysWsClient {

    protected RestTemplate restTemplate;
    protected AbstractArchiveWsConfig config;

    public ProjectAssaysWsClient(RestTemplate restTemplate, AbstractArchiveWsConfig config) {
        this.restTemplate = restTemplate;
        this.config = config;
    }

    public AssayList findAllByProjectAccession(String projectAccession){

       String url = String.format("%s://%s/pride/ws/archive/assay/list/project/%s",
                config.getProtocol(), config.getHostName(), projectAccession);

        return this.restTemplate.getForObject(url, AssayList.class);
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
