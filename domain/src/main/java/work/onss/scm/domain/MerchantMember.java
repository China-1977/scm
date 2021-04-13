package work.onss.scm.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Data
@Entity(name="merchant_member")
public class MerchantMember implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private Long id ;
    /** 合作商ID */
    private String merchantId ;
    /** 雇员ID */
    private String memberId ;
}