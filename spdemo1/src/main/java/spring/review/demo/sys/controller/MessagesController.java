package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.entity.Inform;
import spring.review.demo.sys.entity.Messagelist;
import spring.review.demo.sys.entity.Messages;
import spring.review.demo.sys.service.IInformService;
import spring.review.demo.sys.service.IMessagelistService;
import spring.review.demo.sys.service.IMessagesService;

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
}
