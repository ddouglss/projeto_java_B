package com.initial.bookstoremanager.mapper;

import com.initial.bookstoremanager.dto.BookDTO;
import com.initial.bookstoremanager.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    @Mapping(source = "chapters", target = "chapters") // Garantindo que o campo será mapeado
    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}

