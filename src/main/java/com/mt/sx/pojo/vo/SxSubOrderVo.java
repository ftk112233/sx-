package com.mt.sx.pojo.vo;

        import com.mt.sx.pojo.SxOrder;
        import com.mt.sx.pojo.SxOrderInfo;
        import com.mt.sx.pojo.SxSubOrder;
        import lombok.Data;

        import java.math.BigDecimal;

@Data
public class SxSubOrderVo extends SxSubOrder {
    private String productName;//商品名称
    private String pic;//商品图片
    private String description;//描述信息
    private BigDecimal price;//商品单价
    private Integer num;//数量
    private Integer type;//状态
    private String businessName;//商家名称
    private String name;//个人信息的名字
    private String telephone;//个人信息的名称
    private String address;//个人信息的地址
}
