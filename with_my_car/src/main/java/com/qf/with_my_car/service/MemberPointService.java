package com.qf.with_my_car.service;

import com.qf.with_my_car.pojo.MemberPoint;

import java.util.List;

public interface MemberPointService {
    //    每次登陆获得5个积分
    public Integer insertMemberPoint(MemberPoint memberPoint);
    /*根据会员id取出积分表*/
    public Boolean selectMemberPointByMemberId(Long memberId);
}
