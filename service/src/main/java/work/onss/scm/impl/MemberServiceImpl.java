package work.onss.scm.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import work.onss.scm.domain.Member;
import work.onss.scm.domain.MemberRepository;
import work.onss.scm.exception.ServiceException;
import work.onss.scm.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BCryptPasswordEncoder encoding;

    @Override
    public void create(Member member) {
        String password = encoding.encode(member.getPassword());
        member.setPassword(password);
        memberRepository.save(member);
    }

    @Override
    public Member login(String phone, String password) throws ServiceException {
        Member member = memberRepository.findByPhone(phone).orElseThrow(() -> new ServiceException("FAIL", "用户不存在"));
        if (!encoding.matches(password, member.getPassword())) {
            throw new ServiceException("FAIL", "密码错误");
        }
        return member;
    }

    @Override
    public void delete(String id) {
        memberRepository.deleteById(id);
    }
}
