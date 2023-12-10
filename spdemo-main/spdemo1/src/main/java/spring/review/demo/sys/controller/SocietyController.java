package spring.review.demo.sys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import spring.review.demo.sys.common.Result;
import spring.review.demo.sys.entity.Picurls;
import spring.review.demo.sys.service.impl.SocietyServiceImpl;
import spring.review.demo.sys.utils.AliOSSUtils;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-12-05
 */
@Slf4j
@RestController
@RequestMapping("/sys/society")
public class SocietyController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @Autowired
    private SocietyServiceImpl societyService;

    @Autowired
    private Picurls picurls;

    /**
     * 处理上传图片请求
     *
     * @param images 上传的图片文件数组
     * @return 包含上传结果的Result对象，包含图片访问的URL列表
     * @throws IOException 如果发生文件操作异常
     */

    //这个方法只能传四张图片

    @PostMapping("/upload")
    public Result upload(@RequestParam("images") MultipartFile[] images) throws IOException {
        // 存储上传成功的图片访问URL列表
        List<String> urls = new ArrayList<>();

        // 遍历上传的每张图片
        for (MultipartFile image : images) {
            log.info("文件上传,文件名:{}", image.getOriginalFilename());

            // 使用AliOSS工具类进行文件上传
            String url = aliOSSUtils.upload(image);
            log.info("文件上传成功,访问的url:{}", url);

            // 将图片访问URL添加到列表中
            urls.add(url);

        }

        if (urls.size()<3){
            return Result.error("请上传四张图片");
        }

        // 将图片访问 URL 添加到数据库,只能上传四张图片
        Picurls picurls1=new Picurls();
        picurls1.setUrl1(urls.get(0));
        picurls1.setUrl2(urls.get(1));
        picurls1.setUrl3(urls.get(2));
        picurls1.setUrl4(urls.get(3));
        picurls1.setIsUser(1);
        picurls1.setCreateTimne(LocalTime.now());
        picurls1.setUpdateTime(LocalTime.now());
        picurls1.setCompaniesId(1);
        societyService.savePicurls(picurls1);

        // 返回上传成功的结果，包含图片访问的URL列表
        return Result.success("images", urls);
    }
}
