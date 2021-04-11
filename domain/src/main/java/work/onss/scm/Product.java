package work.onss.scm;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Table(name="product")
public class Product implements Serializable,Cloneable{
    /** 主键 */
    @Id
    @GeneratedValue
    private String id ;
    /** 合作商ID */
    private String merchantId ;
    /** 产品编号 */
    private String code ;
    /** 产品名称 */
    private String name ;
    /** 单位 */
    private String unit ;
    /** 类型 */
    private String type ;
    /** 单价 */
    private String price ;
    /** 状态 */
    private String status ;
    /** 图片 */
    private String pictures ;

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
    /** 产品编号 */
    public String getCode(){
        return this.code;
    }
    /** 产品编号 */
    public void setCode(String code){
        this.code = code;
    }
    /** 产品名称 */
    public String getName(){
        return this.name;
    }
    /** 产品名称 */
    public void setName(String name){
        this.name = name;
    }
    /** 单位 */
    public String getUnit(){
        return this.unit;
    }
    /** 单位 */
    public void setUnit(String unit){
        this.unit = unit;
    }
    /** 类型 */
    public String getType(){
        return this.type;
    }
    /** 类型 */
    public void setType(String type){
        this.type = type;
    }
    /** 单价 */
    public String getPrice(){
        return this.price;
    }
    /** 单价 */
    public void setPrice(String price){
        this.price = price;
    }
    /** 状态 */
    public String getStatus(){
        return this.status;
    }
    /** 状态 */
    public void setStatus(String status){
        this.status = status;
    }
    /** 图片 */
    public String getPictures(){
        return this.pictures;
    }
    /** 图片 */
    public void setPictures(String pictures){
        this.pictures = pictures;
    }
}
