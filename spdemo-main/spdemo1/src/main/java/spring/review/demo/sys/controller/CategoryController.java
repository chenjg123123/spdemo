package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.entity.*;
import spring.review.demo.sys.service.ICategoryService;
import spring.review.demo.sys.service.IPicurlsService;
import spring.review.demo.sys.service.ISocietyService;
import spring.review.demo.sys.service.IUserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-12-11
 */
@RestController
@RequestMapping("/sys/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private ISocietyService societyService;
    @Autowired
    private IPicurlsService picurlsService;
    @Autowired
    private IUserService userService;
    @GetMapping("/list")
    public Result getCategoryList(){
        LambdaQueryWrapper<Category> categoryLambdaQueryWrapper = new LambdaQueryWrapper<>();
        List<Category> categoryList =  categoryService.list(categoryLambdaQueryWrapper);
        return Result.success("categoryList",categoryList);
    }
    @GetMapping("/societyById")
    public Result getCategorySociety(Integer id){
        LambdaQueryWrapper<Society> societyLambdaQueryWrapper = new LambdaQueryWrapper<>();
        societyLambdaQueryWrapper.eq(Society::getCategoryid,id);
        List<Society> list = societyService.list(societyLambdaQueryWrapper);
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
        List<Picurls> picurlsList = list.stream().map(Society::getPicurlsid).collect(Collectors.toList()).stream().map(picUrls->{
            LambdaQueryWrapper<Picurls> picurlsLambdaQueryWrapper = new LambdaQueryWrapper<>();
            picurlsLambdaQueryWrapper.eq(Picurls::getPicurlsid,picUrls);
            return  picurlsService.getOne(picurlsLambdaQueryWrapper);
        }).collect(Collectors.toList());
        list.forEach(item -> {
            LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userLambdaQueryWrapper.eq(User::getId, item.getUserid());
            User user = userService.getOne(userLambdaQueryWrapper);
                item.setUsername(user.getUname());
        });
        return Result.success("list",list).add("picurls",picurlsList);
    }
}
