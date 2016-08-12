package com.exist.services;


import com.exist.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto findOne(Long id);
    List<PersonDto> findAll(String field, String orderStr);
    void delete(Long id);
    void create(PersonDto person);
    void update(PersonDto person);

}
