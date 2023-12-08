package spring.review.demo;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
//import com.baomidou.mybatisplus.annotation.TableFill;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/link?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String password = "chenjg";
        String finalProjectPath = "D:\\Project\\JAVA\\spdemo1";
        String moduleName = "sys";
        String tables = "companies,user,business_demands,messages,society,user_tokens,picurls";

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("abc")
                            .fileOverride()
                            .outputDir(finalProjectPath + "/src/main/java");
                })
                .packageConfig(builder -> {
                    builder.parent("spring.review.demo")
                            .moduleName(moduleName)
                            .pathInfo(Collections.singletonMap(OutputFile.xml, finalProjectPath + "/src/main/resources/mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables);
//                            .addTablePrefix("t_");
//                            .enableTableFieldAnnotation(true)
//                            .entityBuilderModel(true)
//                            .entityLombokModel(true)
//                            .restControllerStyle(true)
//                            .controllerMappingHyphenStyle(true)
//                            .chainModel(true)
//                            .controllerRestStyle(true);
                })
                .templateEngine(new FreemarkerTemplateEngine()).execute();
    }}
