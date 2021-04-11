package work.onss.scm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="order_item")
public class OrderItem implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 合作商ID */
    private String merchantId ;
    /** 订单ID */
    private String orderId ;
    /** 计划ID */
    private String planId ;
    /** 计划编号;年月日+存货编码 */
    private String planCode ;
    /** 产品编号 */
    private String productCode ;
    /** 产品ID */
    private String productId ;
    /** 产品名称 */
    private String productName ;
    /** 产品单价 */
    private Double productPrice ;
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    private String type ;
    /** 加工费 */
    private Double processCost ;
    /** 订单数量 */
    private Long orderQuantity ;
    /** 已完成数量 */
    private Long finishedQuantity ;
    /** 已交付数量 */
    private Long deliveryQuantity ;
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    private String status ;
    /** 交付日期 */
    private Date dueDatetime ;

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
    /** 订单ID */
    public String getOrderId(){
        return this.orderId;
    }
    /** 订单ID */
    public void setOrderId(String orderId){
        this.orderId = orderId;
    }
    /** 计划ID */
    public String getPlanId(){
        return this.planId;
    }
    /** 计划ID */
    public void setPlanId(String planId){
        this.planId = planId;
    }
    /** 计划编号;年月日+存货编码 */
    public String getPlanCode(){
        return this.planCode;
    }
    /** 计划编号;年月日+存货编码 */
    public void setPlanCode(String planCode){
        this.planCode = planCode;
    }
    /** 产品编号 */
    public String getProductCode(){
        return this.productCode;
    }
    /** 产品编号 */
    public void setProductCode(String productCode){
        this.productCode = productCode;
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
    /** 产品单价 */
    public Double getProductPrice(){
        return this.productPrice;
    }
    /** 产品单价 */
    public void setProductPrice(Double productPrice){
        this.productPrice = productPrice;
    }
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    public String getType(){
        return this.type;
    }
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    public void setType(String type){
        this.type = type;
    }
    /** 加工费 */
    public Double getProcessCost(){
        return this.processCost;
    }
    /** 加工费 */
    public void setProcessCost(Double processCost){
        this.processCost = processCost;
    }
    /** 订单数量 */
    public Long getOrderQuantity(){
        return this.orderQuantity;
    }
    /** 订单数量 */
    public void setOrderQuantity(Long orderQuantity){
        this.orderQuantity = orderQuantity;
    }
    /** 已完成数量 */
    public Long getFinishedQuantity(){
        return this.finishedQuantity;
    }
    /** 已完成数量 */
    public void setFinishedQuantity(Long finishedQuantity){
        this.finishedQuantity = finishedQuantity;
    }
    /** 已交付数量 */
    public Long getDeliveryQuantity(){
        return this.deliveryQuantity;
    }
    /** 已交付数量 */
    public void setDeliveryQuantity(Long deliveryQuantity){
        this.deliveryQuantity = deliveryQuantity;
    }
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    public String getStatus(){
        return this.status;
    }
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    public void setStatus(String status){
        this.status = status;
    }
    /** 交付日期 */
    public Date getDueDatetime(){
        return this.dueDatetime;
    }
    /** 交付日期 */
    public void setDueDatetime(Date dueDatetime){
        this.dueDatetime = dueDatetime;
    }
}
