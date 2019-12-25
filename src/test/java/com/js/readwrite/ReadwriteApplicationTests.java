package com.js.readwrite;

import com.js.readwrite.entity.Member;
import com.js.readwrite.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReadwriteApplicationTests {

    @Autowired
    private MemberService memberService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testWrite() {
        Member member = new Member();
        member.setUsername("zhangsan");
        member.setAge(15);
        member.setSex("女");
        memberService.insert(member);
    }

    @Test
    public void testRead() {
        List<Member> list = memberService.all();
        for (Member member : list) {
            System.out.println(member);
        }
    }

    @Test
    public void testSave() {
        Member member = new Member();
        member.setUsername("wangwu");
        member.setAge(15);
        member.setSex("男");
        memberService.save(member);
    }

    @Test
    public void testReadFromMaster() {
        memberService.getToken("1234");
    }

}
