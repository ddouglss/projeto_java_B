package com.initial.bookstoremanager.repository;

import com.initial.bookstoremanager.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {}
