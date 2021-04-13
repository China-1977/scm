package work.onss.scm.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.time.LocalDateTime;

/**
 * 商户登录信息
 *
 * @author wangchanghao
 */
@Log4j2
@Data
@NoArgsConstructor
@ToString
public class Info {
    /**
     * 营业员ID
     */
    private Long memberId;
    /**
     * 商户ID
     */
    private String merchantId;
    /**
     * 营业员登录时间
     */
    private LocalDateTime lastTime;

    public Info(Long memberId,  LocalDateTime lastTime) {
        this.memberId = memberId;
        this.lastTime = lastTime;
    }

    public Info(String cid,  Long memberId, LocalDateTime lastTime) {
        this.memberId = memberId;
        this.merchantId = merchantId;
        this.lastTime = lastTime;
    }
}
