package com.cruds.util;

import com.cruds.entity.Author;
import com.cruds.formbean.AuthorFormBean;

public class AuthorUtil {
	public static Author toEntity(AuthorFormBean formBean) {
        Author author = new Author();
        author.setId(formBean.getId());
        author.setEmail(formBean.getEmail());
        author.setName(formBean.getName());
        author.setBookIsbn(formBean.getBookIsbn());
        return author;
    }

    public static AuthorFormBean toFormBean(Author author) {
        AuthorFormBean formBean = new AuthorFormBean();
        formBean.setId(author.getId());
        formBean.setEmail(author.getEmail());
        formBean.setName(author.getName());
        formBean.setBookIsbn(author.getBookIsbn());
        return formBean;
    }
}
