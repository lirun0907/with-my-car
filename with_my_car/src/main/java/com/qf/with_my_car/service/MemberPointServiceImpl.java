package com.qf.with_my_car.service;

import com.qf.with_my_car.mapper.MemberPointMapper;
import com.qf.with_my_car.pojo.Member;
import com.qf.with_my_car.pojo.MemberPoint;
import com.qf.with_my_car.pojo.MemberPointExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class MemberPointServiceImpl implements MemberPointService {
    @Autowired(required = false)
    private MemberPointMapper memberPointMapper;
    //    每次登陆获得5个积分
    @Override
    public Integer insertMemberPoint(MemberPoint memberPoint) {
        return memberPointMapper.insert(memberPoint);
    }
    /*根据会员id取出积分表*/
    @Override
    public Boolean selectMemberPointByMemberId(Long memberId) {
        MemberPointExample memberPointExample = new MemberPointExample();
        memberPointExample.createCriteria().andMemberIdEqualTo(memberId).andTypeEqualTo(2);
        List<MemberPoint> memberPoints = memberPointMapper.selectByExample(memberPointExample);
        Integer createTime;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String today = dateFormat.format(new Date());
        for (MemberPoint memberPoint:memberPoints) {
            createTime = memberPoint.getCreateTime();
            if(createTime.equals(Integer.valueOf(today))){
                //当天登录过了
                return false;
            }
        }
        return true;
    }
}
