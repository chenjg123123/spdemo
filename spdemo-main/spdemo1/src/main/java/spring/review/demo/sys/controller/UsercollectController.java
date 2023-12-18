package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.entity.Usercollect;
import spring.review.demo.sys.service.IUsercollectService;

import java.util.List;

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

        @GetMapping("/getByUserId")
        public Result getCommunityByUserId(@RequestParam Integer userId){
            LambdaQueryWrapper<Usercollect> userCollectLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userCollectLambdaQueryWrapper.eq(Usercollect::getUserId,userId);
            List<Usercollect> list = usercollectService.list(userCollectLambdaQueryWrapper);
            // 在日志中记录信息
            log.info("查询用户收藏的社区信息成功");

            // 返回结果
            return Result.success("data",list);
        }

}
