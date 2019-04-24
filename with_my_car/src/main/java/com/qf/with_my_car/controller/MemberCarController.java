package com.qf.with_my_car.controller;

import com.qf.with_my_car.dto.MemberCarDto;
import com.qf.with_my_car.pojo.*;
import com.qf.with_my_car.service.MemberCarService;
import com.qf.with_my_car.service.MemberPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MemberCarController {
    /*座驾*/
    @Autowired
    private MemberCarService memberCarService;
    /*积分*/
    @Autowired
    private MemberPointService memberPointService;

    /**
     * 根据座驾id删除座驾
     * @return
     */
    @RequestMapping(value = "deleteMemberCar",method = RequestMethod.POST)
    @ResponseBody
    public Object deleteMemberCar(Long memberCarId){
        return memberCarService.deleteMemberCar(memberCarId);
    }

    /**
     * 根据会员id查询座驾
     * @param session
     * @return
     */
    @RequestMapping(value = "selectAllMemberCarByMemberId",method = RequestMethod.POST)
    @ResponseBody
    public Object selectAllMemberCarByMemberId(HttpSession session){
        Member user = (Member) session.getAttribute("user");
        Long id = user.getId();
        List<MemberCarDto> memberCarDtos = memberCarService.selectAllMemberCarByMemberId(id);
        return memberCarDtos;
    }
    /**
     * 编辑我的座驾
     */
    @RequestMapping(value = "editMemberCar",method = RequestMethod.POST)
    @ResponseBody
    public Object editMemberCar(MemberCar memberCar, HttpSession session) {
        Member user = (Member) session.getAttribute("user");
        Long memberId = user.getId();//会员id
        Long id = memberCar.getId();//座驾id
        /*根据座驾id查询座驾*/
        MemberCar memberCar1 = memberCarService.selectMemberCarById(id);
        System.out.println(memberCar1);
        memberCar1.setBrandId(memberCar.getBrandId());
        memberCar1.setMakeId(memberCar.getMakeId());
        memberCar1.setModelId(memberCar.getModelId());
        memberCar1.setCarId(memberCar.getCarId());
        memberCar1.setBuyYear(memberCar.getBuyYear());
        memberCar1.setCurrentMileage(memberCar.getCurrentMileage());
        memberCar1.setRemark(memberCar.getRemark());
        memberCar1.setType(memberCar.getType());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String lastUpdateTime = dateFormat.format(new Date());
        memberCar1.setLastUpdateTime(Integer.valueOf(lastUpdateTime));
        System.out.println(memberCar1);
        //根据座驾id修改座驾
        return memberCarService.editMemberCarById(memberCar1);
    }
    /**
     * 添加我的座驾
     * @param memberCar
     * @param session
     * @return
     */
    @RequestMapping(value = "addMemberCar",method = RequestMethod.POST)
    @ResponseBody
    public Object addMemberCar(MemberCar memberCar, HttpSession session){
        Member user = (Member) session.getAttribute("user");
        Long id = user.getId();
        Integer numMemberCar = memberCarService.getNumMemberCar(id);
        if(numMemberCar<5) {
            memberCar.setMemberId(id);
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String date = dateFormat.format(new Date());
            memberCar.setCreateTime(Integer.valueOf(date));
            /*添加我的座驾*/
            memberCarService.addMemberCar(memberCar);
            /*添加积分*/
            MemberPoint memberPoint = new MemberPoint();
            memberPoint.setMemberId(id);
            memberPoint.setPoint(5);
            memberPoint.setType(5);
            memberPoint.setDescription("完善我的座驾获取5个积分");
            String date1 = dateFormat.format(new Date());
            memberPoint.setRemark("完善时间为:" + date1);
            memberPoint.setCreateTime(Integer.valueOf(date1));
            memberPointService.insertMemberPoint(memberPoint);
            return 0;
        }else {
            return 1;
        }
    }
    /*查询所有品牌名称*/
    @RequestMapping("mycar")
    @ResponseBody
    public Object mycar(){
        List<CarBrand> carBrands = memberCarService.selectAllCarBrand();
        return carBrands;
    }
    /*根据主品牌id查询所有子品牌*/
    @RequestMapping("selectCarMakeByCarBrandId")
    @ResponseBody
    public Object selectCarMakeByCarBrandId(Integer brandId){
        List<CarMake> carMakes = memberCarService.selectCarMakeByCarBrandId(brandId);
        return carMakes;
    }
    /*根据子品牌id查询车系名称*/
    @RequestMapping("selectCarModelByCarMakeId")
    @ResponseBody
    public Object selectCarModelByCarMakeId(Integer make_id){
        return memberCarService.selectCarModelByCarMakeId(make_id);
    }
    /*根据子品牌id查询车系名称*/
    @RequestMapping("selectCarByCarMakeId")
    @ResponseBody
    public Object selectCarByCarMakeId(Integer make_id){
        List<Car> cars = memberCarService.selectCarByCarMakeId(make_id);
        return cars;
    }





}
