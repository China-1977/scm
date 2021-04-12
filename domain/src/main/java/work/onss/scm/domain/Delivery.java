package work.onss.scm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name="delivery")
public class Delivery implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 合作商ID */
    private String merchantId ;
    /** 合作商名称 */
    private String merchantName ;
    /** 入库ID */
    private String warehouseId ;
    /** 入库名称 */
    private String warehouseName ;
    /** 计划ID */
    private String planId ;
    /** 计划编号 */
    private String planCode ;
    /** 产品ID */
    private String productId ;
    /** 产品编号 */
    private String productCode ;
    /** 产品名称 */
    private String productName ;
    /** 通知数量 */
    private Double deliveryQuantity ;
    /** 签收数量 */
    private Double signQuantity ;
    /** 入库数量 */
    private Double inQuantity ;
    /** 状态;待提交 wait_submit 已提交/接收 wait_cooperate 已接收/进行中 cooperating 已完成 finished 已拒绝 rejected */
    private String status ;
    /** 物流编号 */
    private String logisticNo ;
    /** 创建时间 */
    private Date createDatetime ;
    /** 更新时间 */
    private Date updateDatetime ;

    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id = id;
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
    /** 入库ID */
    public String getWarehouseId(){
        return this.warehouseId;
    }
    /** 入库ID */
    public void setWarehouseId(String warehouseId){
        this.warehouseId = warehouseId;
    }
    /** 入库名称 */
    public String getWarehouseName(){
        return this.warehouseName;
    }
    /** 入库名称 */
    public void setWarehouseName(String warehouseName){
        this.warehouseName = warehouseName;
    }
    /** 计划ID */
    public String getPlanId(){
        return this.planId;
    }
    /** 计划ID */
    public void setPlanId(String planId){
        this.planId = planId;
    }
    /** 计划编号 */
    public String getPlanCode(){
        return this.planCode;
    }
    /** 计划编号 */
    public void setPlanCode(String planCode){
        this.planCode = planCode;
    }
    /** 产品ID */
    public String getProductId(){
        return this.productId;
    }
    /** 产品ID */
    public void setProductId(String productId){
        this.productId = productId;
    }
    /** 产品编号 */
    public String getProductCode(){
        return this.productCode;
    }
    /** 产品编号 */
    public void setProductCode(String productCode){
        this.productCode = productCode;
    }
    /** 产品名称 */
    public String getProductName(){
        return this.productName;
    }
    /** 产品名称 */
    public void setProductName(String productName){
        this.productName = productName;
    }
    /** 通知数量 */
    public Double getDeliveryQuantity(){
        return this.deliveryQuantity;
    }
    /** 通知数量 */
    public void setDeliveryQuantity(Double deliveryQuantity){
        this.deliveryQuantity = deliveryQuantity;
    }
    /** 签收数量 */
    public Double getSignQuantity(){
        return this.signQuantity;
    }
    /** 签收数量 */
    public void setSignQuantity(Double signQuantity){
        this.signQuantity = signQuantity;
    }
    /** 入库数量 */
    public Double getInQuantity(){
        return this.inQuantity;
    }
    /** 入库数量 */
    public void setInQuantity(Double inQuantity){
        this.inQuantity = inQuantity;
    }
    /** 状态;待提交 wait_submit 已提交/接收 wait_cooperate 已接收/进行中 cooperating 已完成 finished 已拒绝 rejected */
    public String getStatus(){
        return this.status;
    }
    /** 状态;待提交 wait_submit 已提交/接收 wait_cooperate 已接收/进行中 cooperating 已完成 finished 已拒绝 rejected */
    public void setStatus(String status){
        this.status = status;
    }
    /** 物流编号 */
    public String getLogisticNo(){
        return this.logisticNo;
    }
    /** 物流编号 */
    public void setLogisticNo(String logisticNo){
        this.logisticNo = logisticNo;
    }
    /** 创建时间 */
    public Date getCreateDatetime(){
        return this.createDatetime;
    }
    /** 创建时间 */
    public void setCreateDatetime(Date createDatetime){
        this.createDatetime = createDatetime;
    }
    /** 更新时间 */
    public Date getUpdateDatetime(){
        return this.updateDatetime;
    }
    /** 更新时间 */
    public void setUpdateDatetime(Date updateDatetime){
        this.updateDatetime = updateDatetime;
    }
}