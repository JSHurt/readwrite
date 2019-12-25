package com.js.readwrite.service;

import com.js.readwrite.aop.Master;
import com.js.readwrite.entity.Member;
import com.js.readwrite.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description:
 * @Author: JS
 * @Date: Created in 2019-7-9 14:26
 */
@Service
public class MemberService {

    @Autowired
    private MemberMapper memberMapper;

    @Transactional(rollbackFor = Exception.class)
    public void insert(Member member) {
         memberMapper.insert(member);
    }

    @Master
    @Transactional(rollbackFor = Exception.class)
    public void save(Member member) {
         memberMapper.insert(member);
    }

    public void delete(String name) {
        memberMapper.delete(name);
    }

    @Master
    public List<Member> all() {
        return memberMapper.selectAll();
    }

    @Master
    public String getToken(String appId) {
// 有些读操作必须读主数据库
// 比如，获取微信access_token，因为高峰时期主从同步可能延迟
// 这种情况下就必须强制从主数据读
        return null;
    }
}
