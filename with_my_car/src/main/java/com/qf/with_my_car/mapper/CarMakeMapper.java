package com.qf.with_my_car.mapper;

import com.qf.with_my_car.pojo.CarMake;
import com.qf.with_my_car.pojo.CarMakeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CarMakeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    int countByExample(CarMakeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    int deleteByExample(CarMakeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    int insert(CarMake record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    int insertSelective(CarMake record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    List<CarMake> selectByExampleWithRowbounds(CarMakeExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    List<CarMake> selectByExample(CarMakeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    CarMake selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CarMake record, @Param("example") CarMakeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CarMake record, @Param("example") CarMakeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CarMake record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_make
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CarMake record);
}