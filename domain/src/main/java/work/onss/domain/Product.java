package work.onss.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 产品
 */
@Data
public class Product {
    /**
     * 产品ID
     */
    private String id;
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
     * 产品损耗
     */
    private BigDecimal loss;
    /**
     * 产品69码
     */
    private String barcode;
    /**
     * 产品国家
     */
    private String country;
    /**
     * 产品分类
     */
    private Category category;
    /**
     * 产品子集
     */
    private List<Product> children;
}
