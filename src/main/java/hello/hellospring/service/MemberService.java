package hello.hellospring.service;

import hello.hellospring.entity.Member;
import hello.hellospring.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    public List<Member> findMembers() {
        return memberMapper.findAll();
    }

}
