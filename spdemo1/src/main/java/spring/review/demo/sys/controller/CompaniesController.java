package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.entity.Society;
import spring.review.demo.sys.entity.SocietyDTO;
import spring.review.demo.sys.entity.User;
import spring.review.demo.sys.mapper.SocietyMapper;
import spring.review.demo.sys.service.ISocietyService;
import spring.review.demo.sys.service.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <p>
 * 企业表 前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@Slf4j
@RestController
@RequestMapping("/sys/companies")
public class CompaniesController {
    @Autowired
    private ISocietyService societyService;
    @Autowired
    private IUserService userService;
    /**
     * @author abc
     * @param id
     * 根据ID返回社区详情
     * @return
     */
    @GetMapping("/inter")
    public Result userGetinter(String id){
        log.info(id);
        LambdaQueryWrapper<Society> societyLambdaQueryWrapper = new LambdaQueryWrapper<>();
        societyLambdaQueryWrapper.eq(Society::getSid,id);
        Society one = societyService.getOne(societyLambdaQueryWrapper);
        return Result.success("id",one);
    }

    /**
     * @author abc
     * @return
     * 返回社区 可以通过分类
     */
    @GetMapping("/list")
    public Result getList() {
        LambdaQueryWrapper<Society> societyLambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 如果不需要附加条件，可以直接忽略此行
        // societyLambdaQueryWrapper.eq(null,null);

        // 获取所有符合条件的数据
        List<Society> list = societyService.list(societyLambdaQueryWrapper);

        // 检查列表长度是否符合你的子列表截取需求
        if (list.size() >= 11) {
            Random random = new Random();

            // 新建一个列表来存放随机选择的数据
            List<Society> randomList = new ArrayList<>();

            // 随机获取10条数据
            while (randomList.size() < 10) {
                int index = random.nextInt(list.size()); // 生成 0 到 list.size()-1 之间的随机数
                Society randomItem = list.get(index); // 获取随机索引对应的对象
                randomList.add(randomItem); // 将对象添加到随机列表中
                list.remove(index); // 从原始列表中移除选中的对象，避免重复选择
            }

            // 更新列表
            list = randomList;
        }
        List<Integer> userIds = list.stream().map(Society::getUserid).collect(Collectors.toList());
        List<User> userList = userIds.stream().map(userId -> {
            LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userLambdaQueryWrapper.eq(User::getId, userId);
            return userService.getOne(userLambdaQueryWrapper);
        }).collect(Collectors.toList());
        for(int i = 0;i<list.size();i++){
            list.get(i).setUsername(userList.get(i).getUname());
        }
        return Result.success("list",list);
    }

}
