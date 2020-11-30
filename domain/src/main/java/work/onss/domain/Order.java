package work.onss.domain;

import lombok.Data;
import work.onss.enums.OrderStatusEnum;

import java.util.List;

/**
 * 订单
 */
@Data
public class Order {
    private String id;
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
}
