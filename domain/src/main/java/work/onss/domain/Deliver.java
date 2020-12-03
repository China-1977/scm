package work.onss.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 订单交付记录
 */
@Data
public class Deliver implements Serializable {
    /**
     * 订单交付ID
     */
    private String id;
    /**
     * 订单交付编号
     */
    private String code;
    /**
     * 商户ID
     */
    private String mid;
    /**
     * 订单交付清单
     */
    List<Product> products;
    /**
     * 物料信息
     */
    private Logistic logistic;
}
