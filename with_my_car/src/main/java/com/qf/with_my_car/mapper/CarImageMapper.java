package com.qf.with_my_car.mapper;

import com.qf.with_my_car.pojo.CarImage;
import com.qf.with_my_car.pojo.CarImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface CarImageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    int countByExample(CarImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    int deleteByExample(CarImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    int insert(CarImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    int insertSelective(CarImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    List<CarImage> selectByExampleWithRowbounds(CarImageExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    List<CarImage> selectByExample(CarImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    CarImage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") CarImage record, @Param("example") CarImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") CarImage record, @Param("example") CarImageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(CarImage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table car_image
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(CarImage record);
}