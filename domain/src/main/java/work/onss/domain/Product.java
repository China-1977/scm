package work.onss.domain;

import lombok.Data;

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
    private String weight;
    /**
     * 产品单价
     */
    private String price;
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
}
