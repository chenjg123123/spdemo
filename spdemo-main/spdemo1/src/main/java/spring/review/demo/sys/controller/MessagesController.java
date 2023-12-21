package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.entity.*;
import spring.review.demo.sys.service.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 私信与业务消息表 前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@RestController
@RequestMapping("/sys/messages")
public class MessagesController {
    @Autowired
    private IMessagesService messagesService;
    @Autowired
    private IInformService informService;
    @Autowired
    private IMessagelistService messagelistService;
    @Autowired
    private ICompaniesService companiesService;
    @Autowired
    private IUserService userService;
    @GetMapping("/messagelist")
    public Result getMessageList(@RequestParam Integer userid){
        LambdaQueryWrapper<Messages> messagesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        messagesLambdaQueryWrapper.eq(Messages::getSenderId,userid).or().eq(Messages::getReceiverCompanyId,userid);
        messagesLambdaQueryWrapper.orderByDesc(Messages::getUpdateTime);
        List<Messages> list = messagesService.list(messagesLambdaQueryWrapper);
        return Result.success("list",list);
    }
    @GetMapping("/informlist")
    public Result getInformList(@RequestParam Integer userid){
        LambdaQueryWrapper<Inform> informLambdaQueryWrapper = new LambdaQueryWrapper<>();
        informLambdaQueryWrapper.eq(Inform::getUserid,userid);
        informLambdaQueryWrapper.orderByDesc(Inform::getCreateTime);
        List<Inform> list =  informService.list(informLambdaQueryWrapper);
        return Result.success("list",list);
    }
    @GetMapping("/informid")
    public Result getInformById(@RequestParam Integer informid){
        LambdaQueryWrapper<Inform> informLambdaQueryWrapper = new LambdaQueryWrapper<>();
        informLambdaQueryWrapper.eq(Inform::getInformid,informid);
        Inform inform =  informService.getOne(informLambdaQueryWrapper);
        return Result.success("inform",inform);
    }
    @GetMapping("/messageid")
    public Result getMessageById(@RequestParam Integer messageid){
        LambdaQueryWrapper<Messagelist> messagelistLambdaQueryWrapper = new LambdaQueryWrapper<>();
        messagelistLambdaQueryWrapper.eq(Messagelist::getMessageid,messageid).last("LIMIT 100").orderByAsc(Messagelist::getCreateTime);
        List<Messagelist> messagelists = messagelistService.list(messagelistLambdaQueryWrapper);
        return Result.success("messagelists",messagelists);
    }
    @PostMapping("/buildchat")
    public Result chatWith( @RequestBody Messages messages1){
        Integer user1 = messages1.getSenderId();
        Integer user2 = messages1.getReceiverCompanyId();
        if(user1==null||user2==null){
            return Result.error("聊天打开失败");
        }
        LambdaQueryWrapper<User> companiesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        companiesLambdaQueryWrapper.eq(User::getId,user2);
        User one1 = userService.getOne(companiesLambdaQueryWrapper);
        LambdaQueryWrapper<Companies> companiesLambdaQueryWrapper1 = new LambdaQueryWrapper<>();
        companiesLambdaQueryWrapper1.eq(Companies::getCompanyId,one1.getCompanyId());
        Companies one3 = companiesService.getOne(companiesLambdaQueryWrapper1);
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getId,user1);
        User one2 = userService.getOne(userLambdaQueryWrapper);
        LambdaQueryWrapper<Messages> messagesLambdaQueryWrapper = new LambdaQueryWrapper<>();
        messagesLambdaQueryWrapper.eq(Messages::getSenderId,user1);
        messagesLambdaQueryWrapper.eq(Messages::getReceiverCompanyId,user2);
        Messages one = messagesService.getOne(messagesLambdaQueryWrapper);
        if(one==null){
            Messages messages = new Messages();
            messages.setSenderId(user1);
            messages.setSenderName(one2.getUname());
            messages.setReceiverCompanyId(user2);
            messages.setReceiverName(one3.getCompanyName());
            messages.setCreateTime(LocalDateTime.now());
            messagesService.save(messages);
            one = messagesService.getOne(messagesLambdaQueryWrapper);
            return Result.success("one",one);
        }

        return Result.success("one",one);
    }
}
