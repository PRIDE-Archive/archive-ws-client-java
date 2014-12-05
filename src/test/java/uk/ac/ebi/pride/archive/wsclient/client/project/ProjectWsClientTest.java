package uk.ac.ebi.pride.archive.wsclient.client.project;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.projectsummary.ProjectSummaryList;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;

/**
 * @author ypriverol
 */

@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class ProjectWsClientTest {

    @Autowired
    AbstractArchiveWsConfig archiveWsConfig;
    ProjectWsClient projectWsClient;

    @Before
    public void setUp() throws Exception {
        projectWsClient = new ProjectWsClient(archiveWsConfig);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testList() throws Exception {

        ProjectSummaryList res = projectWsClient.list("",1,10);

        assertNotNull(res);
        assertNotNull(res.list);
        assertTrue(res.list.length > 0);
        assertTrue(res.list.length == 10);

    }

    @Test
    public void testListParameters() throws Exception {

        ProjectSummaryList res = projectWsClient.list("",1,10, new String[]{"human", "mouse"},null,null,null,null,null,null,null);
        assertNotNull(res);
        assertNotNull(res.list);
        assertTrue(res.list.length > 0);
        assertTrue(res.list.length == 10);

    }
}