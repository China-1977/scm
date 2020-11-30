package work.onss.domain;

import lombok.Data;

import java.util.List;

/**
 * 订单
 */
@Data
public class Order {
    private String id;
    private List<Product> products;

}
