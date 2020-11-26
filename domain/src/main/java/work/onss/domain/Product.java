package work.onss.domain;

import lombok.Data;

@Data
public class Product {
    private String id;// 产品主键
    private String name;// 产品名称
    private String number; // 产品编号
    private String weight;// 产品质量
    private String price;// 产品单价
    private String barcode;// 产品69码
    private String country;// 产品国家
    private Category category;
}
