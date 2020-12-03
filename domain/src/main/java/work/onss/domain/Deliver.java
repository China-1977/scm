package work.onss.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
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
     * 商户ID
     */
    private String mid;
    /**
     * 订单交付编号
     */
    private String code;
    /**
     * 订单交付清单
     */
    List<Cargo> cargos;
    /**
     * 物料信息
     */
    private Logistic logistic;

    @Data
    private static class Cargo implements Serializable{
        /**
         * 产品ID
         */
        private String id;
        /**
         * 计划ID
         */
        private String planId;
        /**
         * 计划编号
         */
        private String planCode;
        /**
         * 订单ID
         */
        private String orderId;
        /**
         * 订单编号
         */
        private String orderCode;
        /**
         * 合同编号
         */
        private String contractCode;
        /**
         * 产品名称
         */
        private String name;
        /**
         * 产品编号
         */
        private String number;
        /**
         * 产品质量
         */
        private BigDecimal weight;
        /**
         * 产品单价
         */
        private BigDecimal price;
        /**
         * 产品69码
         */
        private String barcode;
        /**
         * 产品分类
         */
        private Category category;
        /**
         * 产品子集
         */
        private List<Product> children;
        /**
         * 交付数量
         */
        private BigDecimal count;
    }

}
