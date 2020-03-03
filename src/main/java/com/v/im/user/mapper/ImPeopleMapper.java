package com.v.im.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.v.im.user.entity.ImPeople;

import java.util.List;

public interface ImPeopleMapper extends BaseMapper<ImPeople> {

    List<ImPeople> getPeopleByCode(String code,String userid);
}
