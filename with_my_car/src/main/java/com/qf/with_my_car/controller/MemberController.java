package com.qf.with_my_car.controller;

import com.qf.with_my_car.interceptor.BaseController;
import com.qf.with_my_car.pojo.Member;
import com.qf.with_my_car.pojo.MemberPoint;
import com.qf.with_my_car.service.MemberPointService;
import com.qf.with_my_car.service.MemberProfileService;
import com.qf.with_my_car.service.MemberService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MemberController{
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberPointService memberPointService;
    @Autowired
    private MemberProfileService memberProfileService;
    @RequestMapping("/{url}")
    public String getUrl(@PathVariable String url){
        return url;
    }
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    /**
     * 首页跳转登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录页面跳转注册
     *
     * @return
     */
    @RequestMapping("/regist")
    public String regist() {
        return "regist";
    }

    /**
     * 登录成功后跳转会员中心
     *
     * @return
     */
    @RequestMapping("/userindex")
    public String userindex() {
        return "userindex";
    }

    /**
     * 如果没有完善信息,需跳转完善信息页面
     * @return
     */
    @RequestMapping(value = "/myaccount",method = RequestMethod.GET)
    public String myaccount() {
        return "myaccount";
    }


    @RequestMapping("/checkLogin")
    @ResponseBody
    public Object checkLogin(@RequestBody Member member, HttpSession session) {
//        System.out.println(member);
        String username = member.getUsername();
//        根据名字从库中查出对象
        Member member1 = memberService.selectMemberByUserneme(username);
        if (member1 != null) {
            Long id = member1.getId();
            Boolean aBoolean = memberProfileService.selectMemberProfileById(id);
            if (aBoolean) {
                //            根据id判断用户有没有完善信息
//            取出库中的密码
                String password1 = member1.getPassword();
//            给用户传进来的密码加密
                String password = member.getPassword();
                SimpleHash md5 = new SimpleHash("MD5", password, username, 1024);
//                System.out.println(md5);
                if (password1.equals(md5.toString())) {
//                密码一致
                    member1.setPassword(null);
                    session.setAttribute("user", member1);
                    MemberPoint memberPoint = new MemberPoint();
                    memberPoint.setMemberId(member1.getId());
                    memberPoint.setPoint(5);
                    memberPoint.setType(2);
                    memberPoint.setDescription("登录获取5个积分");
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
                    //根据会员id取出积分表,判断当天是否登录过
                    Boolean aBoolean1 = memberPointService.selectMemberPointByMemberId(member1.getId());
                    if(aBoolean1){
                        String date = dateFormat.format(new Date());
                        memberPoint.setRemark("登录时间为:" + date);
                        memberPoint.setCreateTime(Integer.valueOf(date));
                        memberPointService.insertMemberPoint(memberPoint);
                    }
                    return 2;

                } else {
//                密码不正确
                    return 1;
                }
            }else {
//               进行完善信息
                session.setAttribute("user", member1);
                return 3;
            }
        } else {
//            用户不存在
            return 0;
        }
    }

    /**
     * 给首页显示用户名
     * @param session
     * @return
     */
    @RequestMapping("/getUser")
    @ResponseBody
    public Object getUsername(HttpSession session){
       return session.getAttribute("user");
    }
    /**
     * 销毁session，跳转至登录页面
     * @param session
     * @return
     */
    @RequestMapping("/loginOut")
    @ResponseBody
    public Object loginOut(HttpSession session){
        session.invalidate();
        return true;
    }

}



