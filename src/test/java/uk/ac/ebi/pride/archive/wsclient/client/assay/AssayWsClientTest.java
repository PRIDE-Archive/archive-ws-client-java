package uk.ac.ebi.pride.archive.wsclient.client.assay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import uk.ac.ebi.pride.archive.wsclient.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.wsclient.model.assay.AssayDetail;

import static org.junit.Assert.*;

@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class AssayWsClientTest {

    @Autowired
    AbstractArchiveWsConfig archiveWsConfig;
    AssayWsClient assayWsClient;

    @Before
    public void setUp() throws Exception {
        assayWsClient = new AssayWsClient(archiveWsConfig);
    }

    @Test
    public void testGetAssayByAccession() throws Exception {
        AssayDetail res = assayWsClient.getAssayByAccession("");

        assertNotNull(res);
        assertNotNull(res.instrumentNames.length > 0);

    }

}