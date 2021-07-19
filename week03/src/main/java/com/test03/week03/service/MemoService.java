package com.test03.week03.service;

import com.test03.week03.domain.Memo;
import com.test03.week03.domain.MemoRepository;
import com.test03.week03.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor //final 생성할때 넣어줌 오류 삭제
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional //DB에 반영 반드시 필요
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        memo.update(requestDto);
        return memo.getId();
    }
}