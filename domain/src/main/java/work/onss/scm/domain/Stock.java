package work.onss.scm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name="stock")
public class Stock implements Serializable,Cloneable{
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
    /** 库存剩余量 */
    private Long stockQuantity ;
    /** 批次 */
    private String batch ;
}