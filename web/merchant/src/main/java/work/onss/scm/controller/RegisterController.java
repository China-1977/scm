package work.onss.scm.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.onss.scm.domain.Member;
import work.onss.scm.service.MemberService;

@Log4j2
@RestController
public class RegisterController {

    @Autowired
    private MemberService memberService;


    /**
     * @param member 成员
     * @return 成员
     */
    @Transactional
    @PostMapping(value = {"/register"})
    public Member wxLogin(@RequestBody Member member) {
        memberService.create(member);
        return member;
    }
}

