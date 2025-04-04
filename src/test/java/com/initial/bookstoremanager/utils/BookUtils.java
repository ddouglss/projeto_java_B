package com.initial.bookstoremanager.utils;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.javafaker.Faker;
import com.initial.bookstoremanager.dto.BookDTO;
import com.initial.bookstoremanager.entity.Book;

import static com.initial.bookstoremanager.utils.AuthorUtils.createFakeAuthor;
import static com.initial.bookstoremanager.utils.AuthorUtils.createFakeAuthorDTO;

public class BookUtils {

    private static final Faker faker = Faker.instance();

    public static BookDTO createFakeBookDTO(){
        return BookDTO.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0,200))
                .chapters(faker.number().numberBetween(1,20))
                .isbn("0-596-52068-9")
                .publisherName(faker.book().publisher())
                .author(createFakeAuthorDTO())
                .build();
    }
    public static Book createFakeBook(){
        return Book.builder()
                .id(faker.number().randomNumber())
                .name(faker.book().title())
                .pages(faker.number().numberBetween(0,200))
                .chapters(faker.number().numberBetween(1,20))
                .isbn("0-596-52068-9")
                .publisherName(faker.book().publisher())
                .author(createFakeAuthor())
                .build();
    }

    public static String asJsonString(BookDTO bookDTO){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModule(new JavaTimeModule());

            return objectMapper.writeValueAsString(bookDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
