package work.onss.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 库存记录：订单交付出入库、销售出入库、调拨出入库、盘点出入库、其它出入库
 *
 */
@Data
public class InventoryRecord {
    /**
     * 库存记录ID
     */
    private String id;
    /**
     * 合同编号
     */
    private String contractCode;
    /**
     * 商户ID
     */
    private String mid;
    /**
     * 来源ID
     */
    private String sourceId;
    /**
     * 来源编码
     */
    private String sourceCode;
    /**
     * 产品ID
     */
    private String productId;
    /**
     * 出库仓ID
     */
    private String outId;
    /**
     * 出库仓名称
     */
    private String outName;
    /**
     * 出库仓编码
     */
    private String outCode;
    /**
     * 入库仓ID
     */
    private String inId;
    /**
     * 入库仓名称
     */
    private String inName;
    /**
     * 入库仓编码
     */
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
    private BigDecimal returnCount;
    /**
     * 单价
     */
    private BigDecimal price;
    /**
     * 运费
     */
    private BigDecimal freight;
    /**
     *  加工费
     */
    private BigDecimal processCost;
}