package com.test03.week03.controller;

import com.test03.week03.domain.Memo;
import com.test03.week03.domain.MemoRepository;
import com.test03.week03.domain.MemoRequestDto;
import com.test03.week03.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
//new 요청 처리문구
public class MemoController {

    private final MemoRepository memoRepository; //업데이트
    private final MemoService memoService; //나머지

    @PostMapping("/api/memos")//RequestBody가 없으면 오류
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }
    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }
    @DeleteMapping("/api/memos/{id}") //PathVariable는 {}사이 값을 가져오려고 쓰는 것이다.
    public Long deleteMemo(@PathVariable Long id) {
        memoRepository.deleteById(id);
        return id;
    }
    @PutMapping("api/memos/{id}")
    public Long updateMemo(@PathVariable long id,@RequestBody MemoRequestDto requestDto){
        memoService.update(id,requestDto);
        return id;
    }
}
