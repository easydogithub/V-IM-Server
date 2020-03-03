package com.v.im.api.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.v.im.api.entity.FavResult;
import com.v.im.user.entity.ImGroup;
import com.v.im.user.entity.ImPeople;
import com.v.im.user.entity.ImUser;
import com.v.im.user.entity.ImUserFriend;
import com.v.im.user.service.IImGroupService;
import com.v.im.user.service.IImPeopleService;
import com.v.im.user.service.IImUserFriendService;
import com.v.im.user.service.IImUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/people")
public class ImPeopleController {

    @Resource
    @Qualifier(value = "imPeopleService")
    private IImPeopleService iImPeopleService;

    @Resource
    @Qualifier(value = "imUserService")
    private IImUserService imUserService;

    @Resource
    @Qualifier(value = "imGroupService")
    private IImGroupService iImGroupService;

    @Resource
    @Qualifier(value = "imUserFriendService")
    private IImUserFriendService imUserFriendService;

    @RequestMapping("list")
    public List<ImPeople> getPeoples(String code) {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        ImUser user = imUserService.getByLoginName(username);
        return iImPeopleService.getPeopleByCode(code,user.getId());
    }

    @PostMapping("fav")
    public FavResult favorite(ImUser imUser) {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        ImUser user = imUserService.getByLoginName(username);
        Map<String,Object> map = new HashMap<>();
        map.put("user_id",user.getId());
        map.put("name","标星用户");
        ImGroup group = iImGroupService.getOne(new QueryWrapper<ImGroup>().allEq(map));
        if (null == group) {
            ImGroup imGroup = new ImGroup();
            imGroup.preInsert();
            imGroup.setName("标星用户");
            imGroup.setUserId(user.getId());
            iImGroupService.save(imGroup);
            group = imGroup;
        }
        map.clear();
        map.put("user_id",user.getId());
        map.put("friend_id",imUser.getId());
        ImUserFriend imUserFriend = imUserFriendService.getOne(new QueryWrapper<ImUserFriend>().allEq(map));

        FavResult result = new FavResult();
        if (null == imUserFriend) {
            ImUserFriend userFriend = new ImUserFriend();
            userFriend.preInsert();
            userFriend.setUserId(user.getId());
            userFriend.setFriendId(imUser.getId());
            userFriend.setUserGroupId(group.getId());
            imUserFriendService.save(userFriend);
            result.setAction("a");
        } else {
            imUserFriendService.removeByMap(map);
            result.setAction("d");
        }
        result.setResultCode(FavResult.SUCCESS);
        return result;
    }
}
