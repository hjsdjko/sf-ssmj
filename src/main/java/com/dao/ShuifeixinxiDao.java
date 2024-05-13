package com.dao;

import com.entity.ShuifeixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShuifeixinxiView;

/**
 *  Dao 接口
 *
 * @author 
 * @since 2021-01-30
 */
public interface ShuifeixinxiDao extends BaseMapper<ShuifeixinxiEntity> {

   List<ShuifeixinxiView> selectListView(Pagination page, @Param("params") Map<String, Object> params);

}
