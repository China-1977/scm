package work.onss.scm.domain;

import javax.persistence.*;
import java.io.Serializable;


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

    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id = id;
    }
    /** 产品ID */
    public String getProductId(){
        return this.productId;
    }
    /** 产品ID */
    public void setProductId(String productId){
        this.productId = productId;
    }
    /** 产品名称 */
    public String getProductName(){
        return this.productName;
    }
    /** 产品名称 */
    public void setProductName(String productName){
        this.productName = productName;
    }
    /** 合作商ID */
    public String getMerchantId(){
        return this.merchantId;
    }
    /** 合作商ID */
    public void setMerchantId(String merchantId){
        this.merchantId = merchantId;
    }
    /** 合作商名称 */
    public String getMerchantName(){
        return this.merchantName;
    }
    /** 合作商名称 */
    public void setMerchantName(String merchantName){
        this.merchantName = merchantName;
    }
    /** 仓库ID */
    public String getWarehouseId(){
        return this.warehouseId;
    }
    /** 仓库ID */
    public void setWarehouseId(String warehouseId){
        this.warehouseId = warehouseId;
    }
    /** 仓库名称 */
    public String getWarehouseName(){
        return this.warehouseName;
    }
    /** 仓库名称 */
    public void setWarehouseName(String warehouseName){
        this.warehouseName = warehouseName;
    }
    /** 库存剩余量 */
    public Long getStockQuantity(){
        return this.stockQuantity;
    }
    /** 库存剩余量 */
    public void setStockQuantity(Long stockQuantity){
        this.stockQuantity = stockQuantity;
    }
    /** 批次 */
    public String getBatch(){
        return this.batch;
    }
    /** 批次 */
    public void setBatch(String batch){
        this.batch = batch;
    }
}