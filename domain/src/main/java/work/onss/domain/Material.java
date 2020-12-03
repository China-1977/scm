package work.onss.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 原料
 */
@Data
public class Material {
    /**
     * 原料ID
     */
    private String id;
    /**
     * 原料名称
     */
    private String name;
    /**
     * 原料编号
     */
    private String number;
    /**
     * 原料质量
     */
    private BigDecimal weight;
    /**
     * 原料单价
     */
    private BigDecimal price;
    /**
     * 原料69码
     */
    private String barcode;
    /**
     * 原料国家
     */
    private String country;
    /**
     * 原料分类
     */
    private Category category;
}
