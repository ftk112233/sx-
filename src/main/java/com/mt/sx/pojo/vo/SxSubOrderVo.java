package com.mt.sx.pojo.vo;

        import com.mt.sx.pojo.SxOrder;
        import com.mt.sx.pojo.SxOrderInfo;
        import com.mt.sx.pojo.SxSubOrder;
        import lombok.Data;

        import java.math.BigDecimal;

@Data
public class SxSubOrderVo extends SxSubOrder {
    private String productName;
    private String pic;
    private String description;
    private BigDecimal price;//商品单价
    private Integer num;
    private Integer type;//状态
    private String businessName;
    private String name;
    private String telephone;
    private String address;
}
