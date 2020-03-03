package com.v.im.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.v.im.user.entity.ImPeople;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IImPeopleService extends IService<ImPeople> {

    /**
     * 根据编码获得树
     * @param code
     * @return
     */
    List<ImPeople> getPeopleByCode(@Param("code") String code,@Param("userid") String userid);
}
