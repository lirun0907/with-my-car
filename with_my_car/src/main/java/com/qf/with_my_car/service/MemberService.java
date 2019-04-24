package com.qf.with_my_car.service;

import com.qf.with_my_car.pojo.Member;
import com.qf.with_my_car.pojo.MemberPoint;

public interface MemberService {
//    根据用户名查询用户
    public Member selectMemberByUserneme(String username);

}
