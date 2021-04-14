package work.onss.scm.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Data
@Entity(name="orders_item")
public class OrdersItem implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private Long id ;
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
    private BigDecimal productPrice ;
    /** 类型;采购 purchase、生产 produce、委外 outsource */
    private TypeEnum type ;
    /** 加工费 */
    private BigDecimal processCost ;
    /** 订单数量 */
    private BigDecimal orderQuantity ;
    /** 已交付数量 */
    private BigDecimal deliveryQuantity ;
    /** 状态;准备 read、开始 start、暂停 suspend、完成 finish、停止 stop */
    private StatusEnum status ;
    /** 交付日期 */
    private LocalDateTime dueDatetime ;

    @Getter
    @AllArgsConstructor
    public static enum StatusEnum implements Serializable,Cloneable{
        READ("准备"),
        START("开始"),
        SUSPEND("暂停"),
        FINISH("完成"),
        STOP("停止");
        private final String message;
    }
    
}