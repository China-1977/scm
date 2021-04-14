package work.onss.scm.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import work.onss.scm.domain.Member;
import work.onss.scm.service.MemberService;
import work.onss.scm.vo.Info;
import work.onss.scm.vo.SystemConfig;
import work.onss.scm.vo.Work;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Log4j2
@RestController
@Api("登录")
public class LoginController {

    @Autowired
    private MemberService memberService;
    @Autowired
    private SystemConfig systemConfig;


    /**
     * @param member 微信登陆信息
     * @return 密钥
     */
    @ApiOperation("login")
    @PostMapping(value = {"/login"})
    public Map<String, Object> wxLogin( Member member) throws Exception {
        member = memberService.login(member.getPhone(), member.getPassword());
        Map<String, Object> result = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
        Algorithm algorithm = Algorithm.HMAC256(systemConfig.getSecret());
        JWTCreator.Builder jwt = JWT.create()
                .withIssuer("1977")
                .withAudience("Merchant")
                .withExpiresAt(Date.from(now.toInstant(ZoneOffset.ofHours(6))))
                .withNotBefore(Date.from(now.toInstant(ZoneOffset.ofHours(8))))
                .withIssuedAt(Date.from(now.toInstant(ZoneOffset.ofHours(8))));
        Info info = new Info(member.getId(), now);
        Gson gson = new Gson();
        String authorization = jwt
                .withSubject(gson.toJson(info))
                .withJWTId(member.getId().toString())
                .sign(algorithm);
        try{
            List<String> list = new ArrayList();
            list.add("*");
            result.put("status", "ok");
            result.put("currentAuthority",list);
            result.put("sessionKey", authorization);
            result.put("info", info);
        }catch (Exception e){
            result.put("status", "error");
            result.put("reason", e.getClass().getSimpleName());
            result.put("currentAuthority", "-");
        }
        return result;

    }

    @PostMapping("/logout")
    public Work<Map<String, Object>> logout(){
        return Work.success();
    }
}

