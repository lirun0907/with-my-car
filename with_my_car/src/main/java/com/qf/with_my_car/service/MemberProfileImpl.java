package com.qf.with_my_car.service;

import com.qf.with_my_car.mapper.MemberProfileMapper;
import com.qf.with_my_car.pojo.Member;
import com.qf.with_my_car.pojo.MemberProfile;
import com.qf.with_my_car.pojo.MemberProfileExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberProfileImpl implements MemberProfileService {
    @Autowired
    private MemberProfileMapper memberProfileMapper;

    @Override
    public Boolean selectMemberProfileById(Long id) {
        MemberProfile memberProfile = memberProfileMapper.selectByPrimaryKey(id);
        String name = memberProfile.getName();
        if(name!=null){
            return true;
        }
        return false;
    }
}
