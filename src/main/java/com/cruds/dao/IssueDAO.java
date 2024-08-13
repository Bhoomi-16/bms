package com.cruds.dao;

import java.util.List;
import com.cruds.entity.Issue;

public interface IssueDAO {
    void create(Issue issue);
    void update(Issue issue);
    List<Issue> getAll();
    Issue findById(Long id);
    void delete(Long id);
    List<Issue> findByBookId(Long bookId);
}
