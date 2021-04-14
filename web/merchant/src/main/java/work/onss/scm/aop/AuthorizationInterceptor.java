package work.onss.scm.aop;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.gson.Gson;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import work.onss.scm.exception.ServiceException;
import work.onss.scm.vo.Info;
import work.onss.scm.vo.SystemConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private SystemConfig systemConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServiceException {
        if (handler instanceof HandlerMethod) {
            String authorization = request.getHeader("authorization");
            if (StringUtils.hasLength(authorization)) {
                Algorithm algorithm = Algorithm.HMAC256(systemConfig.getSecret());
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                jwtVerifier.verify(authorization);
                DecodedJWT decode = JWT.decode(authorization);
                String subject = decode.getSubject();
                log.info(subject);
                String memberId = request.getParameter("memberId");
                if (StringUtils.hasLength(memberId)) {
                    Gson gson = new Gson();
                    Info info = gson.fromJson(subject, Info.class);
                    if (!memberId.equals(info.getMemberId()))  {
                        throw new ServiceException("SESSION_EXPIRE", "请重新登录");
                    }
                }
            }
        }
        return true;
    }
}
