package com.initial.bookstoremanager.service;

import com.initial.bookstoremanager.dto.BookDTO;
import com.initial.bookstoremanager.dto.MessageResponseDTO;
import com.initial.bookstoremanager.entity.Book;
import com.initial.bookstoremanager.mapper.BookMapper;
import com.initial.bookstoremanager.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {
    private IBookRepository bookRepository;

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Autowired
    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(BookDTO bookDTO){
        Book bookToSave = bookMapper.toModel(bookDTO);

        Book savedBook = bookRepository.save(bookToSave);
        return MessageResponseDTO.builder()
                .message("Book created with Id " + savedBook.getId())
                .build();
    }
}
