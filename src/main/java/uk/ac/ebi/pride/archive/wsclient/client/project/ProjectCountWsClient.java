package uk.ac.ebi.pride.archive.wsclient.client.project;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.projectsummary.ProjectSummaryList;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ypriverol
 * @author jadianes
 */
public class ProjectCountWsClient {

    protected RestTemplate restTemplate;
    protected AbstractArchiveWsConfig config;

    public ProjectCountWsClient(AbstractArchiveWsConfig config) {
        this.config = config;
        this.restTemplate = new RestTemplate();
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

    public int getProjectCount(String q, int page, int show) throws IOException {
        Map<String, String> args = new HashMap<String, String>();
        args.put("q", q);
        args.put("page", "" + page);
        args.put("show", "" + show);

        String url = String.format("%s://%s/pride/ws/archive/project/count%s",
                    config.getProtocol(), config.getHostName(), "project/list?q={q}&page={page}&show={show}");


        return this.restTemplate.getForObject(url, Integer.class, args);
    }


    /**
     *
     * @param q Retrieve the information for a particular query trough all the fields
     * @param page
     * @param show
     * @param speciesFilter
     * @param ptmsFilter
     * @param tissueFilter
     * @param diseaseFilter
     * @param titleFilter
     * @param instrumentFilter
     * @param quantificationFilter
     * @param projectTagFilter
     * @return
     * @throws IOException
     */
    public ProjectSummaryList getProjectCount(String q, int page, int show,
                                   String[] speciesFilter,
                                   String[] ptmsFilter,
                                   String[] tissueFilter,
                                   String[] diseaseFilter,
                                   String[] titleFilter,
                                   String[] instrumentFilter,
                                   String[] quantificationFilter,
                                   String[] projectTagFilter) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("q", q);
        args.put("page", "" + page);
        args.put("show", "" + show);
        args.put("speciesFilter", constructComplexFieldFilter(speciesFilter));
        args.put("ptmsFilter", constructComplexFieldFilter(ptmsFilter));
        args.put("tissueFilter", constructComplexFieldFilter(tissueFilter));
        args.put("diseaseFilter", constructComplexFieldFilter(diseaseFilter));
        args.put("titleFilter", constructComplexFieldFilter(titleFilter));
        args.put("instrumentFilter", constructComplexFieldFilter(instrumentFilter));
        args.put("quantificationFilter", constructComplexFieldFilter(quantificationFilter));
        args.put("projectTagFilter", constructComplexFieldFilter(projectTagFilter));

        String url = String.format("%s://%s/pride/ws/archive/%s",
                config.getProtocol(),
                config.getHostName(),
                "project/list?q={q}&page={page}&show={show}&speciesFilter={speciesFilter}&ptmsFilter={ptmsFilter}&tissueFilter={tissueFilter}&diseaseFilter={diseaseFilter}&titleFilter={titleFilter}&instrumentFilter={instrumentFilter}&quantificationFilter={quantificationFilter}&projectTagFilter={projectTagFilter}");

        return this.restTemplate.getForObject(url, ProjectSummaryList.class, args);

    }

    protected String constructComplexFieldFilter(String[] complexFilter) {
        String res = "";
        if(complexFilter != null && complexFilter.length > 0){
            for (int i = 0; i < complexFilter.length -1; i ++)
                if(complexFilter[i] != null)
                    res = res + complexFilter[i] + ",";
            if(complexFilter[complexFilter.length -1] != null)
                res = res + complexFilter[complexFilter.length -1];
        }
        return res;
    }
}
