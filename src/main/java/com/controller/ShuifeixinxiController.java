package com.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.ShuibiaoxinxiEntity;
import com.entity.YonghuxinxiEntity;
import com.service.ShuibiaoxinxiService;
import com.service.YonghuxinxiService;
import com.util.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.ShuifeixinxiEntity;

import com.service.ShuifeixinxiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-01-30
*/
@RestController
@Controller
@RequestMapping("/shuifeixinxi")
public class ShuifeixinxiController {
    private static final Logger logger = LoggerFactory.getLogger(ShuifeixinxiController.class);

    @Autowired
    private ShuifeixinxiService shuifeixinxiService;

    @Autowired
    private YonghuxinxiService yonghuxinxiService;

    @Autowired
    private ShuibiaoxinxiService shuibiaoxinxiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        Object role = request.getSession().getAttribute("role");
        PageUtils page = null;
        if(role.equals("用户")){
            params.put("yh",request.getSession().getAttribute("userId"));
            page = shuifeixinxiService.queryPage(params);
        }else{
            page = shuifeixinxiService.queryPage(params);
        }
        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        ShuifeixinxiEntity shuifeixinxi = shuifeixinxiService.selectById(id);
        if(shuifeixinxi!=null){
            return R.ok().put("data", shuifeixinxi);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShuifeixinxiEntity shuifeixinxi, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        Wrapper<ShuifeixinxiEntity> queryWrapper = new EntityWrapper<ShuifeixinxiEntity>()
            .eq("yh_types", shuifeixinxi.getYhTypes())
            .eq("sb_types", shuifeixinxi.getSbTypes());
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShuifeixinxiEntity shuifeixinxiEntity = shuifeixinxiService.selectOne(queryWrapper);
        //根据前端选择用户id进行查询数据
        YonghuxinxiEntity yonghuxinxiEntity = yonghuxinxiService.selectOne(new EntityWrapper<YonghuxinxiEntity>().eq("id",shuifeixinxi.getYhTypes()));
        //根据用户id查出来的水表id进行查询数据
        ShuibiaoxinxiEntity shuibiaoxinxiEntity = shuibiaoxinxiService.selectOne(new EntityWrapper<ShuibiaoxinxiEntity>().eq("id",yonghuxinxiEntity.getSbTypes()));
        //将根据用户id查出来的水表id进行赋值到水费信息表中
        shuifeixinxi.setSbTypes(yonghuxinxiEntity.getSbTypes());
        //将水表信息中的水价格赋值到水费信息表中
        shuifeixinxi.setMoney(shuibiaoxinxiEntity.getMoney());
        //判断上月是否有抄表数据
        String s = Common.addDay(shuifeixinxi.getMoneyTime(), -1).substring(0,7);
        Wrapper<ShuifeixinxiEntity> query = new EntityWrapper<ShuifeixinxiEntity>()
                .eq("money_time", s)
                .eq("yh_types", shuifeixinxi.getYhTypes());
        ShuifeixinxiEntity shuifei = shuifeixinxiService.selectOne(query);
        if(shuifei != null){
            if(shuifei.getLastmeter() != null && shuifei.getLastmeter() >= 0){

                shuifeixinxi.setLastmeter(shuifei.getMeterdata());
            }else{
                //没有就赋值为0
                shuifeixinxi.setLastmeter(0);
            }
        }else{
            //没有就赋值为0
            shuifeixinxi.setLastmeter(0);
        }
        //将用户传过来的抄表信息减去上次抄表信息
        if(shuifeixinxi.getMeterdata() > shuifeixinxi.getLastmeter()){
            shuifeixinxi.setUseyield(shuifeixinxi.getMeterdata()-shuifeixinxi.getLastmeter());
        }else{
            return R.error(511,"你抄错表了把");
        }
        //把用水量乘以水费价格
        shuifeixinxi.setMaxmoney(shuifeixinxi.getUseyield()*shuifeixinxi.getMoney());
        //设置缴费时间
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date());
        cd.add(Calendar.MONTH,1);
        //缴费时间为当前时间加上一个月
        shuifeixinxi.setNoticeTime(cd.getTime());

        if(shuifeixinxiEntity==null){
            shuifeixinxiService.insert(shuifeixinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        shuifeixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

