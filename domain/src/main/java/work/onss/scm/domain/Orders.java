package work.onss.scm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name="orders")
public class Orders implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 合作商ID */
    private String merchantId ;
    /** 合作商名称 */
    private String merchantName ;
    /** 签约时间 */
    private Date signDatetime ;
    /** 状态;待提交 wait_submit 已提交/待接收 wait_cooperate 已接收/进行中 cooperating  已完成 finished 已拒绝 rejected */
    private String status ;
    /** 更新时间 */
    private Date updateDatetime ;
    /** 创建时间 */
    private Date createDatetime ;

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
    /** 签约时间 */
    public Date getSignDatetime(){
        return this.signDatetime;
    }
    /** 签约时间 */
    public void setSignDatetime(Date signDatetime){
        this.signDatetime = signDatetime;
    }
    /** 状态;待提交 wait_submit 已提交/待接收 wait_cooperate 已接收/进行中 cooperating  已完成 finished 已拒绝 rejected */
    public String getStatus(){
        return this.status;
    }
    /** 状态;待提交 wait_submit 已提交/待接收 wait_cooperate 已接收/进行中 cooperating  已完成 finished 已拒绝 rejected */
    public void setStatus(String status){
        this.status = status;
    }
    /** 更新时间 */
    public Date getUpdateDatetime(){
        return this.updateDatetime;
    }
    /** 更新时间 */
    public void setUpdateDatetime(Date updateDatetime){
        this.updateDatetime = updateDatetime;
    }
    /** 创建时间 */
    public Date getCreateDatetime(){
        return this.createDatetime;
    }
    /** 创建时间 */
    public void setCreateDatetime(Date createDatetime){
        this.createDatetime = createDatetime;
    }
}