package com.mysite.sbb;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SbbApplicationTests {
    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void testJpa() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreationDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreationDate(LocalDateTime.now());
        this.questionRepository.save(q2);
    }
    @Test
    void questionFindAllTest() {
        List<Question> questions = this.questionRepository.findAll();
        assertEquals(2,questions.size());
        Question q=questions.get(0);
        assertEquals("sbb에 대해서 알고 싶습니다.",q.getContent());
    }
    @Test
    void questionFindByIdTest() {
        Question q=this.questionRepository.findById(1).get();
    }
    @Test
    void questionFindBySubjectTest() {
        Optional<Question> oq=this.questionRepository.findBySubject("sbb가 무엇인가요?");
        Question q=oq.get();
        System.out.printf(q.getContent());
    }
    @Test
    void questionFindAllBySubjectLikeTest() {
        List<Question> lq=this.questionRepository.findAllBySubjectLike("%.%");
        for(Question q:lq){
            System.out.printf(q.getContent());
        }
    }
}
