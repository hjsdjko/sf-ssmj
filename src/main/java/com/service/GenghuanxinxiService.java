package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GenghuanxinxiEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-01-30
 */
public interface GenghuanxinxiService extends IService<GenghuanxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}