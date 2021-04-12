package work.onss.scm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity(name="orders_item")
public class OrdersItem implements Serializable,Cloneable{
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
    /** 产品ID */
    private String productId ;
    /** 产品编号 */
    private String productCode ;
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
    /** 已交付数量 */
    private Long deliveryQuantity ;
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    private String status ;
    /** 交付日期 */
    private Date dueDatetime ;
}