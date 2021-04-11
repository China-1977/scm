package work.onss.scm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name="merchant")
public class Merchant implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 合作商编号 */
    private String code ;
    /** 合作商名称 */
    private String name ;
    /** 简介;年月日+存货编码 */
    private String description ;
    /** 营业执照编号 */
    private String licenseNumber ;
    /** 营业执照图片 */
    private String licenseCopy ;
    /** 商标 */
    private String trademark ;
    /** 地址;{"username":"王先生","phone":"12345678901","name":"三一堂基督教","detail":"福建省厦门市思明区安海路46号","point":{"x":118.06715,"y":24.44464}} */
    private String address ;
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    private String type ;
    /** 等级 */
    private Integer grade ;
    /** 已交付数量 */
    private Long deliveryQuantity ;
    /** 状态;编辑中 EDITTING 审核中 AUDITING 已驳回 REJECTED 已完成 FINISHED 已作废 CANCELED */
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
    /** 合作商编号 */
    public String getCode(){
        return this.code;
    }
    /** 合作商编号 */
    public void setCode(String code){
        this.code = code;
    }
    /** 合作商名称 */
    public String getName(){
        return this.name;
    }
    /** 合作商名称 */
    public void setName(String name){
        this.name = name;
    }
    /** 简介;年月日+存货编码 */
    public String getDescription(){
        return this.description;
    }
    /** 简介;年月日+存货编码 */
    public void setDescription(String description){
        this.description = description;
    }
    /** 营业执照编号 */
    public String getLicenseNumber(){
        return this.licenseNumber;
    }
    /** 营业执照编号 */
    public void setLicenseNumber(String licenseNumber){
        this.licenseNumber = licenseNumber;
    }
    /** 营业执照图片 */
    public String getLicenseCopy(){
        return this.licenseCopy;
    }
    /** 营业执照图片 */
    public void setLicenseCopy(String licenseCopy){
        this.licenseCopy = licenseCopy;
    }
    /** 商标 */
    public String getTrademark(){
        return this.trademark;
    }
    /** 商标 */
    public void setTrademark(String trademark){
        this.trademark = trademark;
    }
    /** 地址;{"username":"王先生","phone":"12345678901","name":"三一堂基督教","detail":"福建省厦门市思明区安海路46号","point":{"x":118.06715,"y":24.44464}} */
    public  String getAddress(){
        return this.address;
    }
    /** 地址;{"username":"王先生","phone":"12345678901","name":"三一堂基督教","detail":"福建省厦门市思明区安海路46号","point":{"x":118.06715,"y":24.44464}} */
    public void setAddress(String address){
        this.address = address;
    }
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    public String getType(){
        return this.type;
    }
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    public void setType(String type){
        this.type = type;
    }
    /** 等级 */
    public Integer getGrade(){
        return this.grade;
    }
    /** 等级 */
    public void setGrade(Integer grade){
        this.grade = grade;
    }
    /** 已交付数量 */
    public Long getDeliveryQuantity(){
        return this.deliveryQuantity;
    }
    /** 已交付数量 */
    public void setDeliveryQuantity(Long deliveryQuantity){
        this.deliveryQuantity = deliveryQuantity;
    }
    /** 状态;编辑中 EDITTING 审核中 AUDITING 已驳回 REJECTED 已完成 FINISHED 已作废 CANCELED */
    public String getStatus(){
        return this.status;
    }
    /** 状态;编辑中 EDITTING 审核中 AUDITING 已驳回 REJECTED 已完成 FINISHED 已作废 CANCELED */
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
