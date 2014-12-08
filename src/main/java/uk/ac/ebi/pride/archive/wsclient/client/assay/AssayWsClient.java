package uk.ac.ebi.pride.archive.wsclient.client.assay;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.assay.AssayDetail;

/**
 * @author ypriverol
 */
public class AssayWsClient  {

    protected RestTemplate restTemplate;
    protected AbstractArchiveWsConfig config;

    public AssayWsClient(RestTemplate restTemplate, AbstractArchiveWsConfig config) {
        this.restTemplate = restTemplate;
        this.config = config;
    }

    public AssayDetail getAssayByAccession(String assayAccession){

        String url = String.format("%s://%s/pride/ws/archive/assay/%s",
                config.getProtocol(), config.getHostName(), assayAccession);


        return this.restTemplate.getForObject(url, AssayDetail.class);
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
