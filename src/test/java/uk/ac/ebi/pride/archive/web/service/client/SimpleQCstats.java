package uk.ac.ebi.pride.archive.web.service.client;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uk.ac.ebi.pride.archive.web.service.client.assay.ProjectAssaysWsClient;
import uk.ac.ebi.pride.archive.web.service.client.project.ProjectCountWsClient;
import uk.ac.ebi.pride.archive.web.service.client.project.ProjectSummaryWsClient;
import uk.ac.ebi.pride.archive.web.service.client.project.ProjectWsClient;
import uk.ac.ebi.pride.archive.web.service.config.AbstractArchiveWsConfig;
import uk.ac.ebi.pride.archive.web.service.model.assay.AssayDetail;
import uk.ac.ebi.pride.archive.web.service.model.assay.AssayList;
import uk.ac.ebi.pride.archive.web.service.model.projectsummary.ProjectSummary;
import uk.ac.ebi.pride.archive.web.service.model.projectsummary.ProjectSummaryList;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Simple example to check all the components. This example retrieve for all the projects
 * PRIDE Archive the assays and for all the assays the difference between number of Spectra and
 * Identified Spectra.
 */

@ContextConfiguration(locations = {"/test-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class SimpleQCstats {

    @Autowired
    AbstractArchiveWsConfig archiveWsConfig;

    ProjectCountWsClient projectCountWsClient;
    ProjectSummaryWsClient projectWsClient;
    ProjectAssaysWsClient projectAssaysWsClient;

    @Before
    public void setUp() throws Exception {
        projectCountWsClient = new ProjectCountWsClient(archiveWsConfig);
        projectWsClient = new ProjectSummaryWsClient(archiveWsConfig);
        projectAssaysWsClient = new ProjectAssaysWsClient(archiveWsConfig);

    }

    @Test
    public void majorAssayWithUnIdentifiedSpectra() throws Exception {

        Integer res = projectCountWsClient.getProjectCount("");

        int i =0;

        double difference = 0;
        String projectID = null;
        String assayID   = null;
        while ( i < res){

            ProjectSummaryList projects = projectWsClient.list("",i,i + 10);
            i = i + 10;

            for(ProjectSummary project: projects.list){
                AssayList assays = projectAssaysWsClient.findAllByProjectAccession(project.accession);
                for(AssayDetail assay: assays.list){
                    double actualDif = assay.totalSpectrumCount - assay.identifiedSpectrumCount;
                    if (actualDif > difference){
                       difference = actualDif;
                       projectID = project.accession;
                       assayID   = assay.assayAccession;
                    }
                }
            }
        }
        System.out.println("The project-assay with the major difference between spectra and identified spectra is: " + projectID + "\t" + assayID);
    }

}
