package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.entity.Community;
import spring.review.demo.sys.entity.Picurls;
import spring.review.demo.sys.service.ICommunityService;
import spring.review.demo.sys.service.IPicurlsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 社区内容前端控制器
 */
@Slf4j
@RestController
@RequestMapping("/sys/community")
public class CommunityController {

    @Autowired
    private ICommunityService communityService;
    @Autowired
    private IPicurlsService picurlsService;

    /**
     * 获取所有社区内容
     */
    @GetMapping("/all")
    public Result getAllCommunities() {
        LambdaQueryWrapper<Community>  communityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Community> list = communityService.list(communityLambdaQueryWrapper);
        if (list.size() >= 11) {
            Random random = new Random();
            // 新建一个列表来存放随机选择的数据
            List<Community> randomList = new ArrayList<>();

            // 随机获取10条数据
            while (randomList.size() < 10) {
                int index = random.nextInt(list.size()); // 生成 0 到 list.size()-1 之间的随机数
                Community randomItem = list.get(index); // 获取随机索引对应的对象
                randomList.add(randomItem); // 将对象添加到随机列表中
                list.remove(index); // 从原始列表中移除选中的对象，避免重复选择
            }
            // 更新列表
            list = randomList;

        }

        List<Picurls> list1 = new ArrayList<>();
        list.stream().forEach(item->{
            LambdaQueryWrapper<Picurls> picurlsLambdaQueryWrapper= new LambdaQueryWrapper<>();
            picurlsLambdaQueryWrapper.eq(Picurls::getPicurlsid,item.getPicurlsid());
            Picurls p1 = picurlsService.getOne(picurlsLambdaQueryWrapper);
            System.out.println(p1);
            list1.add(p1);
        });
        return  Result.success("communities",list).add("picurls",list1);
    }

    /**
     * 根据公司ID获取社区内容
     */
    @GetMapping("/byCompanyId")
    public Result getCommunitiesByCompanyId(@RequestParam Integer communityId) {
        // 进行查询并返回结果
        LambdaQueryWrapper<Community> communityLambdaQueryWrapper = new LambdaQueryWrapper<>();
        communityLambdaQueryWrapper.eq(Community::getCommunityId,communityId);
        Community one = communityService.getOne(communityLambdaQueryWrapper);
        LambdaQueryWrapper<Picurls> picurlsLambdaQueryWrapper = new LambdaQueryWrapper<>();
        picurlsLambdaQueryWrapper.eq(Picurls::getPicurlsid,one.getPicurlsid());
        Picurls one1 = picurlsService.getOne(picurlsLambdaQueryWrapper);
        return Result.success("comunity", one, "查询成功").add("picurls",one1);
    }
}
