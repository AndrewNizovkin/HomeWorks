package ru.geekbrains.homework3.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.homework3.models.Issue;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {
    private List<Issue> issues;

    public IssueRepository() {
        issues = new ArrayList<>();
    }

    /**
     * Gets all issue list
     * @return
     */
    public List<Issue> getAll() {
        return List.copyOf(issues);
    }
    /**
     * Adds issue to issues
     * @param issue
     */
    public void createIssue(Issue issue) {
        issues.add(issue);
    }

    /**
     * Gets issue from issue list by id
     * @param id
     * @return
     */
    public Issue getById(long id) {
        return issues.stream()
                .filter(issue -> issue.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
