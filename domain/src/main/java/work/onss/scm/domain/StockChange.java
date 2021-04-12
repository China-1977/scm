package work.onss.scm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
    /** 合作商ID */
    private String merchantId ;
    /** 合作商名称 */
    private String merchantName ;
    /** 仓库ID */
    private String warehouseId ;
    /** 仓库名称 */
    private String warehouseName ;
    /** 出入库之前的剩余量 */
    private Long stockQuantity ;
    /** 入库数量 */
    private Double inQuantity ;
    /** 出库数量 */
    private Double outQuantity ;
    /** 批次 */
    private String batch ;
}