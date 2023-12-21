package spring.review.demo.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.entity.Picurls;
import spring.review.demo.sys.entity.Society;
import spring.review.demo.sys.entity.User;
import spring.review.demo.sys.service.IPicurlsService;
import spring.review.demo.sys.service.ISocietyService;
import spring.review.demo.sys.service.IUserService;
import spring.review.demo.sys.utils.AliOSSUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-12-05
 */
@RestController
@RequestMapping("/sys/society")
public class SocietyController {
    @Autowired
    private ISocietyService societyService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IPicurlsService picurlsService;
    @GetMapping("/stitle")
    public Result searchByTitle( @RequestParam String title,@RequestParam Integer currentPage,@RequestParam Integer size) {
        LambdaQueryWrapper<Society> societyLambdaQueryWrapper = new LambdaQueryWrapper<>();
        societyLambdaQueryWrapper.like(Society::getTitle, title);
        PageHelper.startPage(currentPage, size);
        List<Society> pageData = societyService.list(societyLambdaQueryWrapper);
        PageInfo<Society> page = new PageInfo<>(pageData,1);
        page.getList().forEach(item -> {
            LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
            userLambdaQueryWrapper.eq(User::getId, item.getUserid());
            User user = userService.getOne(userLambdaQueryWrapper);
            item.setUsername(user.getUname());
        });
        List<Picurls> picurlsList = page.getList().stream().map(item -> {
            LambdaQueryWrapper<Picurls> picurlsLambdaQueryWrapper = new LambdaQueryWrapper<>();
            picurlsLambdaQueryWrapper.eq(Picurls::getPicurlsid,item.getPicurlsid());
            Picurls one = picurlsService.getOne(picurlsLambdaQueryWrapper);
            return one;
        }).collect(Collectors.toList());
        return Result.success("page", page).add("picurls",picurlsList);
    }
    @PutMapping("/upload")
    public Result upload(HttpServletRequest httpServletRequest) throws IOException {
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) httpServletRequest);
        List<MultipartFile> files = ((MultipartHttpServletRequest) httpServletRequest).getFiles("imageFile");
        System.out.println(files.size());
        String userid = params.getParameter("userid");
        String title = params.getParameter("title");
        String content = params.getParameter("content");
        String categoryid = params.getParameter("categoryid");
        ArrayList<String> arrayList = new ArrayList<>();
        AliOSSUtils aliOSSUtils = new AliOSSUtils();
        for(int i = 0;i<files.size();i++){
            System.out.println(i);
            arrayList.add(aliOSSUtils.upload(files.get(i)));
        }
        Picurls picurls = new Picurls();
        picurls.SetPic(arrayList);
        Picurls picurls1 = picurlsService.insertAndGet(picurls);
        User user = new User();
        Society society = new Society();
        society.setPicurlsid(Long.parseLong(picurls1.getPicurlsid().toString()));
        society.setUserid(Integer.parseInt(userid));
        society.setTitle(title);
        society.setContent(content);
        society.setCategoryid(Integer.parseInt(categoryid));
        societyService.save(society);
        return Result.success("上传成功");
    }

}
