package com.qf.with_my_car.service;

import com.qf.with_my_car.mapper.MemberMapper;
import com.qf.with_my_car.pojo.Member;
import com.qf.with_my_car.pojo.MemberExample;
import com.qf.with_my_car.pojo.MemberPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberMapper memberMapper;
    //    根据用户名查询用户
    @Override
    public Member selectMemberByUserneme(String username) {
//        System.out.println(username);
        MemberExample memberExample = new MemberExample();
        MemberExample.Criteria criteria = memberExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Member> members = memberMapper.selectByExample(memberExample);

//        System.out.println("库中"+members);
        return members.get(0);
    }


}
