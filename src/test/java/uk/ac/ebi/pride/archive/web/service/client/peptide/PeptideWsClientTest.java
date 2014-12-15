package uk.ac.ebi.pride.archive.web.service.client.peptide;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.archive.web.service.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.web.service.model.peptide.PsmDetailList;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class PeptideWsClientTest {

    @Autowired
    AbstractArchiveWsConfig archiveWsConfig;
    PeptideWsClient peptideWsClient;

    @Before
    public void setUp() throws Exception {
        peptideWsClient = new PeptideWsClient(archiveWsConfig);
    }


    @Test
    public void testGetPsmsByProject() throws Exception {
        peptideWsClient = new PeptideWsClient(archiveWsConfig);
    }

    @Test
    public void testCountPsmsByProject() throws Exception {
        int res = peptideWsClient.countPsmsByProject("PXD000402");
        assertTrue(res == 70303);
    }

    @Test
    public void testGetPsmsByProjectAndSequence() throws Exception {
        PsmDetailList res = peptideWsClient.getPsmsByProjectAndSequence("PXD000402", "*GGPVSYIS*");
        assertTrue(res != null);
        assertTrue(res.list.length == 5);
    }

    @Test
    public void testCountPsmsByProjectAndSequence() throws Exception {
        int res = peptideWsClient.countPsmsByProjectAndSequence("PXD000402", "*GGPVSYIS*");
        assertTrue(res == 0);
        //Todo: Inconsistency should be 5
    }

    @Test
    public void testGetPsmsByAssay() throws Exception {
        PsmDetailList res = peptideWsClient.getPsmsByAssay("38579", 0, 20);
        assertTrue(res.list.length == 20);
    }

    @Test
    public void testCountPsmsByAssay() throws Exception {
        int res = peptideWsClient.countPsmsByAssay("38579");
        assertTrue(res == 19157);
    }

    @Test
    public void testGetPsmsByAssayAndSequence() throws Exception {
        PsmDetailList res = peptideWsClient.getPsmsByAssayAndSequence("38579", "*GGPVSYIS*");
        assertTrue(res != null);
        assertTrue(res.list.length == 2);
    }

    @Test
    public void testCountPsmsByAssayAndSequence() throws Exception {
        int res = peptideWsClient.countPsmsByAssayAndSequence("38579", "*GGPVSYIS*");
        assertTrue(res == 0);
        //Todo: inconsistency in results check with Florian should be 2
    }


}