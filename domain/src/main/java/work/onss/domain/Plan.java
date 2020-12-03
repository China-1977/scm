package work.onss.domain;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 计划
 */
@Data
public class Plan implements Serializable {
    /**
     * 计划ID
     */
    private String id;
    /**
     * 计划编号
     */
    private String code;
    /**
     * 计划数量
     */
    private BigDecimal count;
    /**
     * 计划待入库订单数量
     */
    private BigDecimal orderCount;
    /**
     * 计划已入库数量
     */
    private BigDecimal inCount;
    /**
     * 计划产品
     */
    private List<Product> products;
    /**
     * 计划创建时间
     */
    private LocalDateTime insertDateTime;
    /**
     * 计划更新时间
     */
    private LocalDateTime updateDateTime;
}
