package com.initial.bookstoremanager.service;

import com.initial.bookstoremanager.dto.MessageResponseDTO;
import com.initial.bookstoremanager.entity.Book;
import com.initial.bookstoremanager.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private IBookRepository bookRepository;

    @Autowired
    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(Book book){
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder()
                .message("Book created with Id " + savedBook.getId())
                .build();
    }
}
