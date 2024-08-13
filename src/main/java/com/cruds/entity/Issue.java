package com.cruds.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="book_id",nullable=false)
    private Book book;

    @Column(name = "issued_to", nullable = false)
    private String issuedTo;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "return_date", nullable = false)
    private LocalDate returnDate;

    public Issue() {
       
    }

    public Issue(Book book, String issuedTo, LocalDate issueDate, LocalDate returnDate) {
        this.book = book;
        this.issuedTo = issuedTo;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Issue [id=" + id + ", book=" + book + ", issuedTo=" + issuedTo + ", issueDate=" + issueDate
                + ", returnDate=" + returnDate + "]";
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getIssuedTo() {
        return issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
