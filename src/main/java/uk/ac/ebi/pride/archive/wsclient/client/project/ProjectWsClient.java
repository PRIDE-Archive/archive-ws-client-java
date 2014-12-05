package uk.ac.ebi.pride.archive.wsclient.client.project;

import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.projectsummary.ProjectSummaryList;

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

    /**
     * Retrieve the information for a particular query trough all the fields
     * @param q Query to search in all the terms in the metadata.
     * @param page Page for the specific query.
     * @param show Number of Projects to be retrieved
     * @return
     * @throws IOException
     */
    public ProjectSummaryList list(String q, int page, int show) throws IOException {

        Map<String, String> args = new HashMap<String, String>();
        args.put("q", q);
        args.put("page", "" + page);
        args.put("show", "" + show);

        String url = String.format("%s://%s/pride/ws/archive/%s",
                config.getProtocol(), config.getHostName(), "project/list?q={q}&page={page}&show={show}");

        return this.restTemplate.getForObject(url, ProjectSummaryList.class, args);

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
    public ProjectSummaryList list(String q, int page, int show,
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
        args.put("speciesFilter", contructComplexFieldFilter(speciesFilter));
        args.put("ptmsFilter", contructComplexFieldFilter(ptmsFilter));
        args.put("tissueFilter", contructComplexFieldFilter(tissueFilter));
        args.put("diseaseFilter", contructComplexFieldFilter(diseaseFilter));
        args.put("titleFilter", contructComplexFieldFilter(titleFilter));
        args.put("instrumentFilter", contructComplexFieldFilter(instrumentFilter));
        args.put("quantificationFilter", contructComplexFieldFilter(quantificationFilter));
        args.put("projectTagFilter", contructComplexFieldFilter(projectTagFilter));

        String url = String.format("%s://%s/pride/ws/archive/%s",
                config.getProtocol(),
                config.getHostName(),
                "project/list?q={q}&page={page}&show={show}&speciesFilter={speciesFilter}&ptmsFilter={ptmsFilter}&tissueFilter={tissueFilter}&diseaseFilter={diseaseFilter}&titleFilter={titleFilter}&instrumentFilter={instrumentFilter}&quantificationFilter={quantificationFilter}&projectTagFilter={projectTagFilter}");

        return this.restTemplate.getForObject(url, ProjectSummaryList.class, args);

    }

    private String contructComplexFieldFilter(String[] complexFilter) {
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
