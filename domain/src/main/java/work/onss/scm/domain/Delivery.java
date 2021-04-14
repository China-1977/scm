package work.onss.scm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;



@Data
@Entity(name="delivery")
public class Delivery implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private Long id ;
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
    @Column(columnDefinition = "DECIMAL(32,8) NOT NULL   COMMENT '通知数量'")
    private BigDecimal deliveryQuantity ;
    /** 签收数量 */
    @Column(columnDefinition = "DECIMAL(32,8) NOT NULL   COMMENT '签收数量'")
    private BigDecimal signQuantity ;
    /** 入库数量 */
    @Column(columnDefinition = "DECIMAL(32,8) NOT NULL   COMMENT '入库数量'")
    private BigDecimal inQuantity ;
    /** 状态;待提交 wait_submit 已提交/接收 wait_cooperate 已接收/进行中 cooperating 已完成 finished 已拒绝 rejected */
    private StatusEnum status ;
    /** 物流编号 */
    private String logisticNo ;
    /** 创建时间 */
    private LocalDateTime createDatetime ;
    /** 更新时间 */
    private LocalDateTime updateDatetime ;

    @Getter
    @AllArgsConstructor
    public static enum StatusEnum implements Serializable,Cloneable{
        WAIT_SUBMIT("待提交"),
        WAIT_COOPERATE("待接收"),
        COOPERATING("进行中"),
        FINISHED("已完成"),
        REJECTED("已拒绝");
        private final String message;
    }

}