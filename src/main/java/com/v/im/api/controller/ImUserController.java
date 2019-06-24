package com.v.im.api.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.v.im.tio.WsOnlineContext;
import com.v.im.user.entity.ImUser;
import com.v.im.user.service.IImUserFriendService;
import com.v.im.user.service.IImUserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.websocket.common.WsPacket;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 前端控制器
 *
 * @author 乐天
 * @since 2018-10-07
 */
@RestController
@RequestMapping("/api/user")
public class ImUserController {

    @Resource
    @Qualifier(value = "imUserService")
    private IImUserService imUserService;

    @Resource
    @Qualifier(value = "imUserFriendService")
    private IImUserFriendService imUserFriendService;


    /**
     * 用户信息初始化
     *
     * @param request request
     * @return json
     */
    @RequestMapping("init")
    public Map<String, Object> list(HttpServletRequest request) {
        Map<String, Object> objectMap = new HashMap<>();

        //获取好友信息
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        ImUser user = imUserService.getByLoginName(username);
        objectMap.put("friends", imUserFriendService.getUserFriends(user.getId()));

        //获取本人信息
        String host = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
        QueryWrapper<ImUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("login_name", username);
        user.setAvatar(host + user.getAvatar());
        user.setPassword(null);
        objectMap.put("me", user);

        //用户的群组信息
        objectMap.put("groups", imUserService.getChatGroups(user.getId()));
        return objectMap;
    }


    /**
     * 获取群组的用户
     *
     * @param chatId 群组id
     * @return 用户List
     */
    @RequestMapping("chatUserList")
    public List<ImUser> chatUserList(String chatId) {
        return imUserService.getChatUserList(chatId);
    }

    /**
     * 发送信息给用户
     * 注意：目前仅支持发送给在线用户
     */
    @PostMapping("sendMsg")
    public void sendMsg(String userId, String msg){
        ChannelContext cc = WsOnlineContext.getChannelContextByUser(userId);
        if(cc!=null && !cc.isClosed){
            Tio.sendToUser(cc.groupContext, userId, new WsPacket(msg.getBytes()));
        }
    }
}
