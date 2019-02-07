package ru.stqa.pft.rest;


import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

import static org.testng.Assert.assertEquals;

public class RestTests extends TestBase {


    @Test (enabled = false)
    public void testCreateIssue() throws IOException {
        Set<Issue> oldIssues = getIssue();
        Issue newIssue = new Issue().withSubject("Test Issue").withDescription("New test issue");
        int issueId = createIssue(newIssue);
        Set<Issue> newIssues = getIssue();
        oldIssues.add(newIssue.withId(issueId));
        assertEquals(newIssues,oldIssues);

    }


    @Test
    public void testIssueStatus () {
        int issueId = 631;

        try {
            skipIfNotFixed(issueId);
            System.out.println("Do something");

        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

}
