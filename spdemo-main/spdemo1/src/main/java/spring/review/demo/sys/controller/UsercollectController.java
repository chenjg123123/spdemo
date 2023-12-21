package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.entity.Community;
import spring.review.demo.sys.entity.Usercollect;
import spring.review.demo.sys.service.ICommunityService;
import spring.review.demo.sys.service.IUsercollectService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 业务收藏表 前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-12-18
 */
@RestController
@RequestMapping("/sys/usercollect")
@Slf4j
public class UsercollectController {
    @Autowired
    private IUsercollectService usercollectService;
    @Autowired
    private ICommunityService communityService;

        @GetMapping("/getByUserId")
        public Result getCommunityByUserId(@RequestParam Integer userId){
            LambdaQueryWrapper<Usercollect> userCollectLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userCollectLambdaQueryWrapper.eq(Usercollect::getUserId,userId);
            List<Usercollect> list = usercollectService.list(userCollectLambdaQueryWrapper);
            List<Community> collect = list.stream().map(item -> {
                LambdaQueryWrapper<Community> communityLambdaQueryWrapper = new LambdaQueryWrapper<>();
                communityLambdaQueryWrapper.eq(Community::getCommunityId, item.getCommunityId());
                Community one = communityService.getOne(communityLambdaQueryWrapper);
                return one;
            }).collect(Collectors.toList());
            // 在日志中记录信息
            log.info("查询用户收藏的社区信息成功");

            // 返回结果
            return Result.success("data",collect);
        }
    /**

     * 收藏或取消收藏社区
     *

     * @param requestBody 包含 userId 和 communityId 的请求体，通过 @RequestBody 注解解析

     * @return 返回包含操作结果的结果对象，如果成功取消收藏，data 部分为 null；如果成功收藏，data 部分为对应的 Community 对象
     */
    @PostMapping("/collectCommunity")
    public Result collectCommunity(@RequestBody Usercollect usercollect) {
        Integer userId = usercollect.getUserId();
        Integer communityId = usercollect.getCommunityId();

        // 查询是否已经收藏
        Usercollect existingUsercollect = usercollectService.getOne(new LambdaQueryWrapper<Usercollect>()
                .eq(Usercollect::getUserId, userId)
                .eq(Usercollect::getCommunityId, communityId));

        if (existingUsercollect == null) {
            // 如果不存在，则插入新的收藏记录
            Usercollect userCollect = new Usercollect();
            userCollect.setUserId(userId);
            userCollect.setCommunityId(communityId);
            userCollect.setCreateTime(LocalDateTime.now());
            userCollect.setUpdateTime(LocalDateTime.now());

            boolean success = usercollectService.save(userCollect);

            if (success) {
                log.info("用户收藏社区成功");
                // 查询对应的 Community 对象
                Community community = communityService.getById(communityId);
                if (community != null) {
                    return Result.success("收藏成功");
                } else {
                    log.error("找不到对应的社区信息");
                    return Result.error("找不到对应的社区信息");
                }
            } else {
                log.error("用户收藏社区失败");
                return Result.error("收藏失败");
            }

        } else {
            // 如果已存在，则删除对应的收藏记录（取消收藏）
            boolean deleteSuccess = usercollectService.removeById(existingUsercollect.getCollectId());

            if (deleteSuccess) {
                log.info("用户取消收藏社区成功");
                return Result.success("取消收藏成功");
            } else {
                log.error("用户取消收藏社区失败");
                return Result.error("取消收藏失败");
            }

        }
    }
        @PostMapping("/isCollect")
        public Result IsCollect(@RequestBody Usercollect usercollect){
            Integer userId = usercollect.getUserId();
            Integer communityId = usercollect.getCommunityId();
            LambdaQueryWrapper<Usercollect> usercollectLambdaQueryWrapper = new LambdaQueryWrapper<>();
            usercollectLambdaQueryWrapper.eq(Usercollect::getUserId,userId);
            usercollectLambdaQueryWrapper.eq(Usercollect::getCommunityId,communityId);
            Usercollect one = usercollectService.getOne(usercollectLambdaQueryWrapper);
            if(one==null)
                return Result.success("code",0);
            return Result.success("code",1);
        }


}
