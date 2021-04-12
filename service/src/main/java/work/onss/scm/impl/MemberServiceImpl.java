package work.onss.scm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.onss.scm.domain.Member;
import work.onss.scm.domain.MemberRepository;
import work.onss.scm.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void create(Member member) {
        memberRepository.save(member);
    }
}
