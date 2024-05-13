package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.ShuibiaoxinxiDao;
import com.entity.ShuibiaoxinxiEntity;
import com.service.ShuibiaoxinxiService;
import com.entity.view.ShuibiaoxinxiView;

/**
 *  服务实现类
 * @author 
 * @since 2021-01-30
 */
@Service("shuibiaoxinxiService")
@Transactional
public class ShuibiaoxinxiServiceImpl extends ServiceImpl<ShuibiaoxinxiDao, ShuibiaoxinxiEntity> implements ShuibiaoxinxiService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<ShuibiaoxinxiView> page =new Query<ShuibiaoxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
