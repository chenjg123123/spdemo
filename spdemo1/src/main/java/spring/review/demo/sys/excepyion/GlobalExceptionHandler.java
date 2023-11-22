package spring.review.demo.sys.excepyion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.review.demo.sys.common.Result;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理方法
     *
     * @param ex 异常对象
     * @return 返回统一的错误结果
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex) {
        log.error("全局异常处理: {}", ex.getMessage(), ex);

        // 返回统一的错误结果
        return Result.error("对不起，操作失败，请联系管理员");
    }
}
