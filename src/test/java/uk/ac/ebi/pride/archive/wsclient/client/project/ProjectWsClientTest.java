package uk.ac.ebi.pride.archive.wsclient.client.project;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.project.ProjectDetails;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

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
    public void testGetProject() throws Exception {

        ProjectDetails project = projectWsClient.getProject("PXD000320");
        assertNotNull(project);

        assertNotNull(project.submitter);
        assertTrue("The submitter is Matthew", project.submitter.firstName.equalsIgnoreCase("Matthew"));

        assertTrue("Partial submission", project.submissionType.equalsIgnoreCase("PARTIAL"));


    }
}