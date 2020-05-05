package com.leyou.item.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.common.vo.PageResult;
import com.leyou.item.mapper.SkuMapper;
import com.leyou.item.mapper.SpuMapper;
import com.leyou.item.pojo.Sku;
import com.leyou.item.pojo.Spu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SpuService {
    @Autowired
    private SpuMapper spuMapper;

    public PageResult<Spu> querySkuByPage(Integer page, Integer rows, String sortBy, Boolean desc, String key) {
        PageHelper.startPage(page, rows);
        Example example = new Example(Spu.class);
        if (StringUtils.isNotBlank(key)) {
            example.createCriteria().orLike("title", "%"+key+"%");
        }
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = desc ? "DESC" : "ASC";
            example.setOrderByClause(sortBy+" "+orderByClause);
        }
        List<Spu> list =  spuMapper.selectByExample(example);
        PageInfo<Spu> pageInfo = new PageInfo<>(list);
        if (CollectionUtils.isEmpty(list)) {
            throw new LyException(ExceptionEnum.SPU_NOT_FOUND);
        }
        return new PageResult<>(pageInfo.getTotal(), list);
    }
}
