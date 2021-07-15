package com.example.demo.controller;

import com.example.demo.prac.Person;
import com.example.demo.prac.PersonRepository;
import com.example.demo.prac.PersonRequestDto;
import com.example.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonService personService;
    private final PersonRepository personRepository;


    @PostMapping("/api/persons")
    public final Person createPerson(@RequestBody PersonRequestDto requestDto){
        // requestDto 는, 생성 요청을 의미합니다. 반드시 필요하다
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Person person = new Person(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return personRepository.save(person);


    }
    @GetMapping("/api/persons")
    public List<Person> readPerson(){
        return personRepository.findAll();
    }
    @PostMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id , @RequestBody PersonRequestDto requestDto){
//        personRepository.findById(id).orElseThrow(
//                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
//        );

        return personService.update(id, requestDto);
    }
    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson(@PathVariable long id){
        personRepository.deleteById(id);
        return id;
    }
}
