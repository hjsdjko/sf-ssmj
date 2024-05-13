package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShuibiaoxinxiEntity;
import java.util.Map;

/**
 *  服务类
 * @author 
 * @since 2021-01-30
 */
public interface ShuibiaoxinxiService extends IService<ShuibiaoxinxiEntity> {

     PageUtils queryPage(Map<String, Object> params);

}