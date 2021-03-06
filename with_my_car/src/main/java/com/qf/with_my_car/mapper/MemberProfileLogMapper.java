package com.qf.with_my_car.mapper;

import com.qf.with_my_car.pojo.MemberProfileLog;
import com.qf.with_my_car.pojo.MemberProfileLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface MemberProfileLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    int countByExample(MemberProfileLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    int deleteByExample(MemberProfileLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    int insert(MemberProfileLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    int insertSelective(MemberProfileLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    List<MemberProfileLog> selectByExampleWithRowbounds(MemberProfileLogExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    List<MemberProfileLog> selectByExample(MemberProfileLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    MemberProfileLog selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") MemberProfileLog record, @Param("example") MemberProfileLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") MemberProfileLog record, @Param("example") MemberProfileLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MemberProfileLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table member_profile_log
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MemberProfileLog record);
}