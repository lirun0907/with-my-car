package com.qf.with_my_car.mapper;

import com.qf.with_my_car.pojo.CarModel;
import com.qf.with_my_car.pojo.CarModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CarModelMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    int countByExample(CarModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    int deleteByExample(CarModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    int insert(CarModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    int insertSelective(CarModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    List<CarModel> selectByExampleWithRowbounds(CarModelExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    List<CarModel> selectByExample(CarModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    CarModel selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CarModel record, @Param("example") CarModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CarModel record, @Param("example") CarModelExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CarModel record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_model
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CarModel record);
}