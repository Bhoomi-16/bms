package com.cruds.formbean;

public class AuthorFormBean {
	 	private int id;
	    private String email;
	    private String name;
	    private String bookIsbn;
		@Override
		public String toString() {
			return "AuthorFormBean [id=" + id + ", email=" + email + ", name=" + name + ", bookIsbn=" + bookIsbn + "]";
		}
		public AuthorFormBean() {
			super();
		
		}
		public AuthorFormBean(int id, String email, String name, String bookIsbn) {
			super();
			this.id = id;
			this.email = email;
			this.name = name;
			this.bookIsbn = bookIsbn;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBookIsbn() {
			return bookIsbn;
		}
		public void setBookIsbn(String bookIsbn) {
			this.bookIsbn = bookIsbn;
		}
}