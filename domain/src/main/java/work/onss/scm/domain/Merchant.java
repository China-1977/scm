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
    /** 雇员ID */
    private String memberId ;
    /** 联系姓名 */
    private String memberName ;
    /** 联系电话;{"username":"王先生","phone":"12345678901","name":"三一堂基督教","detail":"福建省厦门市思明区安海路46号","point":{"x":118.06715,"y":24.44464}} */
    private String memberPhone ;
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    private String type ;
    /** 等级 */
    private Integer grade ;
    /** 状态;编辑中 EDITTING 审核中 AUDITING 已驳回 REJECTED 已完成 FINISHED 已作废 CANCELED */
    private String status ;
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
    /** 雇员ID */
    public String getMemberId(){
        return this.memberId;
    }
    /** 雇员ID */
    public void setMemberId(String memberId){
        this.memberId = memberId;
    }
    /** 联系姓名 */
    public String getMemberName(){
        return this.memberName;
    }
    /** 联系姓名 */
    public void setMemberName(String memberName){
        this.memberName = memberName;
    }
    /** 联系电话;{"username":"王先生","phone":"12345678901","name":"三一堂基督教","detail":"福建省厦门市思明区安海路46号","point":{"x":118.06715,"y":24.44464}} */
    public String getMemberPhone(){
        return this.memberPhone;
    }
    /** 联系电话;{"username":"王先生","phone":"12345678901","name":"三一堂基督教","detail":"福建省厦门市思明区安海路46号","point":{"x":118.06715,"y":24.44464}} */
    public void setMemberPhone(String memberPhone){
        this.memberPhone = memberPhone;
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
    /** 状态;编辑中 EDITTING 审核中 AUDITING 已驳回 REJECTED 已完成 FINISHED 已作废 CANCELED */
    public String getStatus(){
        return this.status;
    }
    /** 状态;编辑中 EDITTING 审核中 AUDITING 已驳回 REJECTED 已完成 FINISHED 已作废 CANCELED */
    public void setStatus(String status){
        this.status = status;
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