package com.js.readwrite.mapper;

import com.js.readwrite.entity.Member;
import java.util.List;

public interface MemberMapper {

    int save(Member member);

    int insert(Member member);

    int delete(String name);

    int update(Member record);

    Member selectByName(String name);

    List<Member> selectAll();
}