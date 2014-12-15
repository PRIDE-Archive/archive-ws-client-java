package uk.ac.ebi.pride.archive.web.service.client.assay;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.archive.web.service.config.AbstractArchiveWsConfig;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class AssayCountWsClientTest {

    @Autowired
    AbstractArchiveWsConfig archiveWsConfig;
    AssayCountWsClient assayCountWsClient;

    @Before
    public void setUp() throws Exception {
        assayCountWsClient = new AssayCountWsClient(archiveWsConfig);
    }

    @Test
    public void testCountByProjectAccession() throws Exception {

        int res = assayCountWsClient.countByProjectAccession("PXD000402");

        assertNotNull(res);
        assertNotNull(res > 0);
        assertTrue(res == 4);
    }

}