package it.maiasolution.issuetracker.model.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import it.maiasolution.issuetracker.model.entity.Issue;

@Repository
public class IssueRepository {
    
    static Map<Integer, Issue> issues ;

    static {
        issues = new HashMap<>();

        Issue issue1 = new Issue("Issue #1", "This is the first issue", "Luigi Bonacina");
        issue1.setId(1);
        Issue issue2 = new Issue("Issue #2", "This is the second issue", "Luigi Bonacina");
        issue2.setId(2);
        Issue issue3 = new Issue("Issue #3", "This is the third issue", "Luigi Bonacina");
        issue3.setId(3);
        Issue issue4 = new Issue("Issue #4", "This is the fourth issue", "Riccardo Venittelli");
        issue4.setId(4);

        issues.put(1, issue1);
        issues.put(2, issue2);
        issues.put(3, issue3);
        issues.put(4, issue4);
    }    

    public Iterable<Issue> findAll() {
        return issues.values();
    }

    public Optional<Issue> findById(Integer id) {
        return Optional.of(issues.get(id));
    }

    public Issue save(Issue item) {
        return issues.put(item.getId(), item);
    }

    public void deleteById(Integer id) {
        issues.remove(id);
    }
}
