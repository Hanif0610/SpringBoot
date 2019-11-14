package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Users;
import org.springframework.stereotype.Repository;

@Repository
//Users에서 삽입, 삭제, 업데이트 등을 할 때 이 인터페이스를 사용함.
public interface UsersRepository extends JpaRepository<Users, Long> { //<>안에서 앞에는 테이블, 뒤에는 id의 어떤 타입으로 지정했는지
    public Users findByUser_idAndUser_pw(String userID, String userPassword);
//이렇게 함수를 구현하면 ORM에서 일할 때 함수 이름을 작성해주면 쿼리 형태로 실행 할 수 있게 함
//자바 코드를 갖고 쿼리를 실행할 수 있게 되는 것이다.
}
