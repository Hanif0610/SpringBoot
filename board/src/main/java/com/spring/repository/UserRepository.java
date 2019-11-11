package com.spring.repository;

import com.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
//<>안쪽에서 앞에는 모델 클래스, 뒷 부분에는 ID를 어떤 타입으로 지정했는지
public interface UserRepository extends JpaRepository<User, Long> {
}
