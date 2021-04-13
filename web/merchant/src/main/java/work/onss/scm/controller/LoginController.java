package work.onss.scm.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.onss.scm.domain.Member;
import work.onss.scm.service.MemberService;
import work.onss.scm.vo.SystemConfig;
import work.onss.scm.vo.Work;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private SystemConfig systemConfig;


    /**
     * @param login 微信登陆信息
     * @return 密钥
     */
    @Transactional
    @PostMapping(value = {"login"})
    public ResponseEntity<Work<Map<String, Object>>> wxLogin(@RequestBody Member member) throws Exception {

        Map<String, Object> result = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
        Algorithm algorithm = Algorithm.HMAC256(systemConfig.getSecret());
        JWTCreator.Builder jwt = JWT.create()
                .withIssuer("1977")
                .withAudience("WeChat")
                .withExpiresAt(Date.from(now.toInstant(ZoneOffset.ofHours(6))))
                .withNotBefore(Date.from(now.toInstant(ZoneOffset.ofHours(8))))
                .withIssuedAt(Date.from(now.toInstant(ZoneOffset.ofHours(8))));

        return ResponseEntity.ok(Work.success(result));
    }
}

