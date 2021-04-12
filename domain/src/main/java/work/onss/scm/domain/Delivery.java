package work.onss.scm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
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

}