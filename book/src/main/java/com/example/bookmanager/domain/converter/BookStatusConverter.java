package com.example.bookmanager.domain.converter;

import com.example.bookmanager.repository.dto.BookStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BookStatusConverter implements AttributeConverter<BookStatus,Integer> {

    @Override
    public Integer convertToDatabaseColumn(BookStatus bookStatus) {
        return bookStatus.getCode();
    }

    @Override
    public BookStatus convertToEntityAttribute(Integer integer) {
        return integer != null ? new BookStatus(integer) : null;
    }
}
