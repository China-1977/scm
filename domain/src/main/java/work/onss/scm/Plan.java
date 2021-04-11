package work.onss.scm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="plan")
public class Plan implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 计划编号;年月日+存货编码 */
    private String planCode ;
    /** 产品编号 */
    private String productCode ;
    /** 产品名称 */
    private String productName ;
    /** 产品ID */
    private String productId ;
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    private String type ;
    /** 开始时间 */
    private Date startDate ;
    /** 截止时间 */
    private Date endDate ;
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    private String status ;
    /** 计划数量 */
    private Long planQuantity ;
    /** 已分配数量 */
    private Long allocatedQuantity ;
    /** 已完成数量 */
    private Long completedQuantity ;
    /** 更新时间 */
    private Date upateDatetime ;

    /** 主键 */
    public String getId(){
        return this.id;
    }
    /** 主键 */
    public void setId(String id){
        this.id = id;
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
    /** 产品名称 */
    public String getProductName(){
        return this.productName;
    }
    /** 产品名称 */
    public void setProductName(String productName){
        this.productName = productName;
    }
    /** 产品ID */
    public String getProductId(){
        return this.productId;
    }
    /** 产品ID */
    public void setProductId(String productId){
        this.productId = productId;
    }
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    public String getType(){
        return this.type;
    }
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    public void setType(String type){
        this.type = type;
    }
    /** 开始时间 */
    public Date getStartDate(){
        return this.startDate;
    }
    /** 开始时间 */
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    /** 截止时间 */
    public Date getEndDate(){
        return this.endDate;
    }
    /** 截止时间 */
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    public String getStatus(){
        return this.status;
    }
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    public void setStatus(String status){
        this.status = status;
    }
    /** 计划数量 */
    public Long getPlanQuantity(){
        return this.planQuantity;
    }
    /** 计划数量 */
    public void setPlanQuantity(Long planQuantity){
        this.planQuantity = planQuantity;
    }
    /** 已分配数量 */
    public Long getAllocatedQuantity(){
        return this.allocatedQuantity;
    }
    /** 已分配数量 */
    public void setAllocatedQuantity(Long allocatedQuantity){
        this.allocatedQuantity = allocatedQuantity;
    }
    /** 已完成数量 */
    public Long getCompletedQuantity(){
        return this.completedQuantity;
    }
    /** 已完成数量 */
    public void setCompletedQuantity(Long completedQuantity){
        this.completedQuantity = completedQuantity;
    }
    /** 更新时间 */
    public Date getUpateDatetime(){
        return this.upateDatetime;
    }
    /** 更新时间 */
    public void setUpateDatetime(Date upateDatetime){
        this.upateDatetime = upateDatetime;
    }
}
