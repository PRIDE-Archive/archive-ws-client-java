package uk.ac.ebi.pride.archive.wsclient.client.project;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.clustersummary.ProjectSummaryList;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jadianes
 * @author ypriverol
 */
public class ProjectWsClient {

    private RestTemplate restTemplate;
    private AbstractArchiveWsConfig config;

    public ProjectWsClient(AbstractArchiveWsConfig config) {
        this.config = config;
        this.restTemplate = new RestTemplate();
    }

    public ProjectSummaryList list(String q, int page, int show) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("q", q);
        args.put("page", "" + page);
        args.put("show", "" + show);

        String url = String.format("%s://%s/pride/ws/archive/%s",
                config.getProtocol(), config.getHostName(), "project/list?q={q}&page={page}&show={show}");

        return this.restTemplate.getForObject(url, ProjectSummaryList.class, args);

    }


}
