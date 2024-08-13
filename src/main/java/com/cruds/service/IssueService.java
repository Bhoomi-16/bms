package com.cruds.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cruds.dao.IssueDAO;
import com.cruds.entity.Issue;

@Service
public class IssueService {

    @Autowired
    private IssueDAO issueDAO;

    @Transactional
    public void create(Issue issue) {
        issueDAO.create(issue);
    }

    @Transactional
    public void update(Issue issue) {
        issueDAO.update(issue);
    }

    public List<Issue> getAll() {
        return issueDAO.getAll();
    }

    public Issue findById(Long id) {
        return issueDAO.findById(id);
    }

    @Transactional
    public void delete(Long id) {
        issueDAO.delete(id);
    }

    public List<Issue> findByBookId(Long bookId) {
        return issueDAO.findByBookId(bookId);
    }
    
}
