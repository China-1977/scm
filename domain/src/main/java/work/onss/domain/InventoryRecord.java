package work.onss.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 库存记录
 */
@Data
public class InventoryRecord {

    private String id;
    /**
     * 来源ID
     */
    private String sourceId;
    private String sourceCode;
    private String productId;
    /**
     * 出库仓ID
     */
    private String outId;
    private String outName;
    private String outCode;
    /**
     * 入库仓ID
     */
    private String inId;
    private String inName;
    private String inCode;

    /**
     * 出库数量
     */
    private BigDecimal outCount;
    /**
     * 入库数量
     */
    private BigDecimal inCount;
    /**
     * 在途数量
     */
    private BigDecimal transitCount;
    /**
     * 接收数量
     */
    private BigDecimal receiveCount;
    /**
     * 退货数量
     */
    private BigDecimal rejectedCount;


}
