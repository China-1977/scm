package work.onss.scm.service;

import work.onss.scm.domain.Member;
import work.onss.scm.exception.ServiceException;

public interface MemberService {

    void create(Member member);

    Member login(String phone, String password) throws ServiceException;

    void delete(Long id);
}
