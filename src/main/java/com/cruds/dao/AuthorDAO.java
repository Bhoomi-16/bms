package com.cruds.dao;

import java.util.List;

import com.cruds.entity.Author;

public interface AuthorDAO {
public void create(Author author);
List<Author> getAll();
public void update(Author author);
}
