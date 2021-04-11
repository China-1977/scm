package work.onss.scm.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity(name="member")
public class Member implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 合作商ID */
    private String merchantId ;
    /** 手机号 */
    private String phone ;
    /** 姓名 */
    private String name ;
    /** 描述 */
    private String description ;
    /** 身份证号 */
    private String cardNumber ;
    /** 身份证照片 */
    private String cardCopy ;
    /** 状态 */
    private String status ;

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
    /** 手机号 */
    public String getPhone(){
        return this.phone;
    }
    /** 手机号 */
    public void setPhone(String phone){
        this.phone = phone;
    }
    /** 姓名 */
    public String getName(){
        return this.name;
    }
    /** 姓名 */
    public void setName(String name){
        this.name = name;
    }
    /** 描述 */
    public String getDescription(){
        return this.description;
    }
    /** 描述 */
    public void setDescription(String description){
        this.description = description;
    }
    /** 身份证号 */
    public String getCardNumber(){
        return this.cardNumber;
    }
    /** 身份证号 */
    public void setCardNumber(String cardNumber){
        this.cardNumber = cardNumber;
    }
    /** 身份证照片 */
    public String getCardCopy(){
        return this.cardCopy;
    }
    /** 身份证照片 */
    public void setCardCopy(String cardCopy){
        this.cardCopy = cardCopy;
    }
    /** 状态 */
    public String getStatus(){
        return this.status;
    }
    /** 状态 */
    public void setStatus(String status){
        this.status = status;
    }
}
