package uk.ac.ebi.pride.archive.web.service.client.protein;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.archive.web.service.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.web.service.model.protein.ProteinDetailList;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class ProteinWsClientTest {

    @Autowired
    AbstractArchiveWsConfig archiveWsConfig;
    ProteinWsClient proteinWsClient;

    @Before
    public void setUp() throws Exception {
        proteinWsClient = new ProteinWsClient(archiveWsConfig);
    }

    @Test
    public void testGetProteinsByProject() throws Exception {
        ProteinDetailList res = proteinWsClient.getProteinsByProject("PXD000402",0,20);
        assertTrue(res != null);
        assertTrue(res.list.length == 20);
        assertTrue(res.list[0].accession.equalsIgnoreCase("239911484"));
    }

    @Test
    public void testCountProteinsByProject() throws Exception {
        int res = proteinWsClient.countProteinsByProject("PXD000402");
        assertTrue(res == 3765);
    }

    @Test
    public void testGetProteinsByAssay() throws Exception {
        ProteinDetailList res = proteinWsClient.getProteinsByAssay("38579",0,100);
        assertTrue(res != null);
        assertTrue(res.list.length == 100);
        assertTrue(res.list[0].accession.equalsIgnoreCase("239911484"));
    }

    @Test
    public void testCountProteinsByAssay() throws Exception {
        int res = proteinWsClient.countProteinsByAssay("38579");
        assertTrue(res == 998);
    }
}