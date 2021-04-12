package work.onss.scm.impl;

import lombok.AllArgsConstructor;
import work.onss.scm.domain.Member;
import work.onss.scm.domain.MemberRepository;
import work.onss.scm.service.MemberService;

@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public void create(Member member) {
        memberRepository.save(member);
    }
}
