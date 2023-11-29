package spring.review.demo.sys.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import spring.review.demo.sys.common.Result;

/**
 * <p>
 * 企业表 前端控制器
 * </p>
 *
 * @author abc
 * @since 2023-11-28
 */
@Slf4j
@Controller
@RequestMapping("/sys/companies")
public class CompaniesController {
    @GetMapping("/inter")
    public Result userGetinter(String id){
        log.info("success");
        return Result.error("success");
    }
}
