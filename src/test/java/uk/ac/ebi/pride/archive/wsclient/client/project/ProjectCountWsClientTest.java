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
import static org.junit.Assert.*;

@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class ProjectCountWsClientTest {

    @Autowired
    AbstractArchiveWsConfig archiveWsConfig;
    ProjectCountWsClient projectCountWsClient;

    @Before
    public void setUp() throws Exception {
        projectCountWsClient = new ProjectCountWsClient(archiveWsConfig);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetRestTemplate() throws Exception {

    }

    @Test
    public void testSetRestTemplate() throws Exception {

    }

    @Test
    public void testGetConfig() throws Exception {

    }

    @Test
    public void testSetConfig() throws Exception {

    }

    @Test
    public void testGetProjectCount() throws Exception {

        Integer res = projectCountWsClient.getProjectCount("");

        assertNotNull(res);
        assertNotNull(res > 0);


    }

    @Test
    public void testGetProjectCountFilters() throws Exception {

        Integer res = projectCountWsClient.getProjectCount("", new String[]{"human", "mouse"},null,null,null,null,null,null,null);
        assertNotNull(res);
        assertNotNull(res > 0);

    }

    @Test
    public void testConstructComplexFieldFilter() throws Exception {

    }
}