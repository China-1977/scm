package work.onss.scm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity(name="stock_change")
public class StockChange implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 产品ID */
    private String productId ;
    /** 产品名称 */
    private String productName ;
    /** 产品金额 */
    private BigDecimal productAmount ;
    /** 运费 */
    private BigDecimal freight ;
    /** 加工费 */
    private BigDecimal processCost ;
    /** 合作商ID */
    private String merchantId ;
    /** 合作商名称 */
    private String merchantName ;
    /** 仓库ID */
    private String warehouseId ;
    /** 仓库名称 */
    private String warehouseName ;
    /** 出入库之前的剩余量 */
    private BigDecimal stockQuantity ;
    /** 入库数量 */
    private BigDecimal inQuantity ;
    /** 出库数量 */
    private BigDecimal outQuantity ;
    /** 批次 */
    private String batch ;
}