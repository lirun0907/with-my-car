package com.qf.with_my_car.service;

import com.qf.with_my_car.dto.MemberCarDto;
import com.qf.with_my_car.pojo.*;

import java.util.List;

public interface MemberCarService {
    /*查询所有品牌名称*/
    public List<CarBrand> selectAllCarBrand();
    /*根据主品牌id查询所有子品牌*/
    public List<CarMake> selectCarMakeByCarBrandId(Integer brandId);

    /**
     * 根据子品牌id查询车系名称
     * @param make_id
     * @return
     */
    public List<CarModel> selectCarModelByCarMakeId(Integer make_id);

    /**
     * 根据carModel表中的make_id查询所有车款
     * @param make_id
     * @return
     */
    public List<Car> selectCarByCarMakeId(Integer make_id);
    /*根据会员id查询用户拥有的座驾个数*/
    public Integer getNumMemberCar(Long memberId);
    /*添加我的座驾*/
    public Integer addMemberCar(MemberCar memberCar);
    /*根据会员id查询已拥有的所有座驾*/
    public List<MemberCarDto> selectAllMemberCarByMemberId(Long memberId);
    /*根据座驾id删除座驾*/
    public Integer deleteMemberCar(Long id);
    /*根据座驾id查出一个座驾*/
    public MemberCar selectMemberCarById(Long id);
    /*根据座驾id修改座驾*/
    public Integer editMemberCarById(MemberCar memberCar);
}
