package work.onss.domain;

import lombok.Data;
import work.onss.enums.OrderStatusEnum;
import work.onss.enums.OrderTypeEnum;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 订单
 */
@Data
public class Score implements Serializable {
    /**
     * 订单ID
     */
    private String id;
    /**
     * 商户ID
     */
    private String mid;
    /**
     * 订单商户
     */
    private Merchant merchant;
    /**
     * 订单清单
     */
    private List<Product> products;
    /**
     * 订单状态
     */
    private OrderStatusEnum status;
    /**
     * 订单开工时间
     */
    private LocalDateTime startDateTime;
    /**
     * 订单完工时间
     */
    private LocalDateTime endDateTime;
    /**
     * 订单交付时间
     */
    private LocalDateTime deliveryDateTime;
    /**
     * 订单创建时间
     */
    private LocalDateTime insertDateTime;
    /**
     * 订单更新时间
     */
    private LocalDateTime updateDateTime;
    /**
     * 订单类型
     */
    private OrderTypeEnum type;
    /**
     * 物流记录
     */
    private List<Logistic> logistics;
}
