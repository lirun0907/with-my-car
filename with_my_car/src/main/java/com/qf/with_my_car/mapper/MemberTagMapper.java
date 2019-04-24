package com.qf.with_my_car.mapper;

import com.qf.with_my_car.pojo.MemberTag;
import com.qf.with_my_car.pojo.MemberTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MemberTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    int countByExample(MemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    int deleteByExample(MemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    int insert(MemberTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    int insertSelective(MemberTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    List<MemberTag> selectByExampleWithRowbounds(MemberTagExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    List<MemberTag> selectByExample(MemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    MemberTag selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MemberTag record, @Param("example") MemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MemberTag record, @Param("example") MemberTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MemberTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_tag
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MemberTag record);
}