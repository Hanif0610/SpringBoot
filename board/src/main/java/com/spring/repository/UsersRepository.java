package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Users;
import org.springframework.stereotype.Repository;

@Repository
//Users에서 삽입, 삭제, 업데이트 등을 할 때 이 인터페이스를 사용함.
public interface UsersRepository extends JpaRepository<Users, Long> { //<>안에서 앞에는 테이블, 뒤에는 id의 어떤 타입으로 지정했는지
    Users findByUserIDAndUserPassword(String userID, String userPassword);
}
