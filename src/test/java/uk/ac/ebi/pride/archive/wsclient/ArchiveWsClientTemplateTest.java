package uk.ac.ebi.pride.archive.wsclient;

import uk.ac.ebi.pride.archive.wsclient.client.project.ProjectWsClient;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.archive.wsclient.model.projectsummary.ProjectSummary;
import uk.ac.ebi.pride.archive.wsclient.model.projectsummary.ProjectSummaryList;

import java.io.IOException;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * @author Jose A. Dianes <jadianes@gmail.com>
 *
 */
@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ArchiveWsClientTemplateTest {

    @Autowired
    AbstractArchiveWsConfig archiveWsConfig;
    ProjectWsClient projectWsClient;

    @Before
    public void init() {
        projectWsClient = new ProjectWsClient(archiveWsConfig);
    }

    @Test
    public void testPredict() throws IOException {

        ProjectSummaryList res = projectWsClient.list("",1,10);

        assertNotNull(res);
        assertNotNull(res.list);
        assertTrue(res.list.length > 0);
        assertTrue(res.list.length == 10);
        for(ProjectSummary project: res.list){
            System.out.println(project.accession);
            for(String instrument : project.instrumentNames){
                System.out.println("\t" + instrument);
            }
        }

    }
}
