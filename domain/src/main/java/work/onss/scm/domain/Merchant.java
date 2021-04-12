package work.onss.scm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
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
    /** 联系电话 */
    private String memberPhone ;
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    private String type ;
    /** 等级 */
    private Integer grade ;
    /** 状态;编辑中 EDITTING 审核中 AUDITING 已驳回 REJECTED 已完成 FINISHED 已作废 CANCELED */
    private StatusEnum status ;
    /** 创建时间 */
    private Date createDatetime ;
    /** 更新时间 */
    private Date updateDatetime ;

    @Getter
    @AllArgsConstructor
    public static enum StatusEnum implements Serializable,Cloneable{
        EDITTING("编辑中"),
        AUDITING("审核中"),
        REJECTED("已驳回"),
        FINISHED("已完成"),
        CANCELED("已作废");
        private final String message;
    }
}