package com.v.im.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.v.im.user.entity.ImChatGroup;
import com.v.im.user.entity.ImGroup;
import com.v.im.user.entity.ImUser;
import com.v.im.user.service.IImUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author v
 * @since 2018-10-07
 */
@RestController
@RequestMapping("/api/user")
public class ImUserController {

    @Autowired
    @Qualifier(value = "imUserService")
    private IImUserService imUserService;

    @RequestMapping("list")
    public List<ImGroup> list() {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        ImUser user = imUserService.getByLoginName(username);
        return imUserService.getGroupUsers(user.getId());
    }

    @RequestMapping("me")
    public ImUser me(HttpServletRequest request) {
        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        QueryWrapper<ImUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", username);
        ImUser imUser = imUserService.getOne(queryWrapper);
        imUser.setAvatar(host + imUser.getAvatar());
        imUser.setPassword(null);
        return imUser;
    }

    @RequestMapping("chatList")
    public List<ImChatGroup> chatList() {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        ImUser user = imUserService.getByLoginName(username);
        return imUserService.getChatGroups(user.getId());
    }


    /**
     * 获取群组的用户
     * @param chatId 群组id
     * @return 用户List
     */
    @RequestMapping("chatUserList")
    public List<ImUser> chatUserList(String chatId) {
        return imUserService.getChatUserList(chatId);
    }
}
