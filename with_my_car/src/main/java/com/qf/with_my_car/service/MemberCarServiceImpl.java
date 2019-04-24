package com.qf.with_my_car.service;

import com.qf.with_my_car.dto.MemberCarDto;
import com.qf.with_my_car.mapper.*;
import com.qf.with_my_car.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberCarServiceImpl implements MemberCarService {
    @Autowired
    private CarBrandMapper carBrandMapper;
    @Autowired
    private CarMakeMapper carMakeMapper;
    @Autowired
    private CarModelMapper carModelMapper;
    @Autowired
    private CarMapper carMapper;
    @Autowired
    private MemberCarMapper memberCarMapper;
    @Autowired
    private CarImageMapper carImageMapper;
    /*查询所有品牌名称*/
    @Override
    public List<CarBrand> selectAllCarBrand() {
        CarBrandExample carBrandExample = new CarBrandExample();
        CarBrandExample.Criteria criteria = carBrandExample.createCriteria();
        return carBrandMapper.selectByExample(carBrandExample);
    }
    /*根据主品牌id查询所有子品牌*/
    @Override
    public List<CarMake> selectCarMakeByCarBrandId(Integer brandId) {
        CarMakeExample carMakeExample = new CarMakeExample();
        CarMakeExample.Criteria criteria = carMakeExample.createCriteria();
        criteria.andBrandIdEqualTo(brandId);
        return carMakeMapper.selectByExample(carMakeExample);
    }

    /**
     * 根据子品牌id查询车系名称
     * @param make_id
     * @return
     */
    @Override
    public List<CarModel> selectCarModelByCarMakeId(Integer make_id) {
        CarModelExample carModelExample = new CarModelExample();
        CarModelExample.Criteria criteria = carModelExample.createCriteria();
        criteria.andMakeIdEqualTo(make_id);
        return carModelMapper.selectByExample(carModelExample);
    }
    /*根据carModel表中的make_id查询所有车款*/
    @Override
    public List<Car> selectCarByCarMakeId(Integer make_id) {
        CarExample carExample = new CarExample();
        CarExample.Criteria criteria = carExample.createCriteria();
        criteria.andMakeIdEqualTo(make_id);
        return carMapper.selectByExample(carExample);
    }
    /*根据会员id查询用户拥有的座驾个数*/
    @Override
    public Integer getNumMemberCar(Long memberId) {
        MemberCarExample memberCarExample = new MemberCarExample();
        MemberCarExample.Criteria criteria = memberCarExample.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        return memberCarMapper.selectByExample(memberCarExample).size();
    }

    /*添加我的座驾*/
    @Override
    public Integer addMemberCar(MemberCar memberCar) {
        return memberCarMapper.insert(memberCar);
    }
    /*根据会员id查询已拥有的所有座驾*/
    @Override
    public List<MemberCarDto> selectAllMemberCarByMemberId(Long memberId) {
        MemberCarExample memberCarExample = new MemberCarExample();
        MemberCarExample.Criteria criteria = memberCarExample.createCriteria();
        criteria.andMemberIdEqualTo(memberId);
        /*根据会员id查出拥有的座驾*/
        List<MemberCar> memberCars = memberCarMapper.selectByExample(memberCarExample);
        ArrayList<MemberCarDto> memberCarDtos = new ArrayList<>();
        for (MemberCar memberCar:memberCars) {
            Long id = memberCar.getId();//座驾id
            MemberCarDto memberCarDto = new MemberCarDto();
            memberCarDto.setMemberCarId(id);
            Integer brandId = memberCar.getBrandId();
            memberCarDto.setBrandName(carBrandMapper.selectByPrimaryKey(brandId).getName());//主品牌名称
            Integer makeId = memberCar.getMakeId();
            String makeName = null;
            if(carMakeMapper.selectByPrimaryKey(makeId)!=null){
                makeName = carMakeMapper.selectByPrimaryKey(makeId).getName();
            }
            memberCarDto.setMakeName(makeName);//子品牌名称
            Integer modelId = memberCar.getModelId();
            String modelName = (carModelMapper.selectByPrimaryKey(modelId)!=null)?(carModelMapper.selectByPrimaryKey(modelId).getName()):null;
            memberCarDto.setModelName(modelName);//车系名称
            CarExample carExample = new CarExample();
            carExample.createCriteria().andMakeIdEqualTo(carModelMapper.selectByPrimaryKey(modelId).getMakeId());
            String carName = carMapper.selectByExample(carExample).size()!=0?carMapper.selectByExample(carExample).get(0).getName():null;
            memberCarDto.setCarName(carName);//车款名称
            memberCarDto.setBuyYear((memberCar.getBuyYear()).toString()); //购买年份
            memberCarDto.setCurrentMileage(memberCar.getCurrentMileage().toString());//当前里程
            memberCarDto.setRemark(memberCar.getRemark());//备注
            memberCarDto.setType(memberCar.getType().equals(1)?"5人座":(memberCar.getType().equals(2)?"7人座":"9人座"));//座驾类型
            Integer carId = memberCar.getCarId();

            CarImageExample carImageExample = new CarImageExample();
            carImageExample.createCriteria().andCarIdEqualTo(carId);
            List<CarImage> carImages = carImageMapper.selectByExample(carImageExample);
            String img = null;
            if(carImages.size()!=0){
                img = carImages.get(0).getImgUrl();
            }
            memberCarDto.setImage(img);//车款图片
            memberCarDtos.add(memberCarDto);
        }
        return memberCarDtos;
    }
    /*根据座驾id删除座驾*/
    @Override
    public Integer deleteMemberCar(Long id) {
        return memberCarMapper.deleteByPrimaryKey(id);
    }
    /*根据座驾id查出一个座驾*/
    @Override
    public MemberCar selectMemberCarById(Long id) {
        return memberCarMapper.selectByPrimaryKey(id);
    }
    /*根据座驾id修改座驾*/
    @Override
    public Integer editMemberCarById(MemberCar memberCar) {
        return memberCarMapper.updateByPrimaryKey(memberCar);
    }
}
