package com.leyou.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum  ExceptionEnum {
    CATEGORY_NOT_FOUND(404, "商品分类未查到!"),
    BRAND_NOT_FOUND(400, "品牌不存在!")
    ;

    private int code;
    private String msg;
}
