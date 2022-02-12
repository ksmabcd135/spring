package hello.hellospring.repository;


import hello.hellospring.entity.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    List<Member> findAll();
}
