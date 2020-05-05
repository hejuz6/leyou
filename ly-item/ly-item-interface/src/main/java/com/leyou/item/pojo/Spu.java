package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "tb_spu")
@Data
public class Spu {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String title;
    private String subTitle;
    private Integer cid1;
    private Integer cid2;
    private Integer cid3;
    private Long brandId;
    private Integer saleable;
    private Integer valid;
    private Date createTime;
    private Date lastUpdateTime;
}
