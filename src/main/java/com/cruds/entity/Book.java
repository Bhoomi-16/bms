package com.cruds.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "isbn", nullable = false)
	    private String isbn;

	    @Column(name = "title", nullable = false)
	    private String title;

	    @Column(name = "category", nullable = false)
	    private String category;

	    @Column(name = "quantity", nullable = false)
	    private Integer quantity;
	    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    private Set<Issue> issues;
	    

		public Book(String isbn, String title, String author, String category, Integer quantity) {
			super();
			this.isbn = isbn;
			this.title = title;
			
			this.category = category;
			this.quantity = quantity;
		}

		public Book() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

	

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		@Override
		public String toString() {
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", category="
					+ category + ", quantity=" + quantity + "]";
		}
	    
}
	  
	

	