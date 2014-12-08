package uk.ac.ebi.pride.archive.wsclient.client.protein;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.archive.wsclient.client.project.ProjectWsClient;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class ProteinWsClientTest {

    @Autowired
    AbstractArchiveWsConfig archiveWsConfig;
    ProteinWsClient projecttWsClient;

    @Before
    public void setUp() throws Exception {
        projecttWsClient = new ProteinWsClient(archiveWsConfig);
    }

    @Test
    public void testGetProteinsByProject() throws Exception {

    }

    @Test
    public void testCountProteinsByProject() throws Exception {

    }

    @Test
    public void testGetProteinsByAssay() throws Exception {

    }

    @Test
    public void testCountProteinsByAssay() throws Exception {

    }
}