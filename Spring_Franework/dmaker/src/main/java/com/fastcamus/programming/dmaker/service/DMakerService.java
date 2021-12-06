package com.fastcamus.programming.dmaker.service;

import com.fastcamus.programming.dmaker.entity.Developer;
import com.fastcamus.programming.dmaker.repository.DeveloperRepository;
import com.fastcamus.programming.dmaker.type.DeveloperLevel;
import com.fastcamus.programming.dmaker.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor // 자동으로 injection
@Transactional // 공통적이고 반복적인 로직이 불필요 try catch rollback
public class DMakerService {
    //@Autowired
    //@Inject
    // 서비스 코드가 어노테이션에 종속적으로 담겨있기 때문에 서비스를 단독으로 만들기 어려움
    private final DeveloperRepository developerRepository; // 자동으로 injection
    private final EntityManager em; /// DB 추상화
    /*public DMakerService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }*/

    @Transactional // ACID 특성을 가짐
    public void createDeveloper(){
        EntityTransaction transaction = em.getTransaction();
        //try {
            //transaction.begin();

            // business logic start

            Developer developer = Developer.builder()
                    .developerLevel(DeveloperLevel.JUNIOR)
                    .developerSkillType(DeveloperSkillType.FRONT_END)
                    .experienceYears(2)
                    .name("Olaf")
                    .age(5)
                    .build();
            
            // a-> b 1만원 송금 로직
            // a 계좌에서 1만원 줄임
            developerRepository.save(developer); // 영속화, DB저장
            // b계좌에서 1만원 늘림
            //developerRepository.delete(developer1);

            // business logic end


            //transaction.commit();
        //}catch (Exception e){
            //transaction.rollback();
            //throw e;
        //}



    }
}
