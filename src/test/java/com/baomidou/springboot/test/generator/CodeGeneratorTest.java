package com.baomidou.springboot.test.generator;

import com.baomidou.mybatisplus.generator.config.*;
import org.junit.Test;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * <p>
 * 测试生成代码
 * </p>
 *
 * @author K神
 * @date 2017/12/18
 */
public class CodeGeneratorTest {

    @Test
    public void generateCode() {
        String packageName = "com.baomidou.springboot";
        boolean serviceNameStartWithI = true;  // false: user -> UserService, 设置成true: user -> IUserService
//        generateByTables(serviceNameStartWithI, packageName, "user", "role");
        generateByTables(serviceNameStartWithI, packageName, "t_category");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        GlobalConfig config = new GlobalConfig();
//        String dbUrl = "jdbc:mysql://localhost:3306/mybatis-plus?characterEncoding=utf8&useUnicode=true&useSSL=false";
        String dbUrl = "jdbc:mysql://localhost:3306/mshop_saas?characterEncoding=utf8&useUnicode=true&useSSL=false";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("mshop")
                .setPassword("mshop")
                .setDriverName("com.mysql.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)           // 是否大写命名
//                .setEntityLombokModel(false)  //【实体】是否为lombok模型（默认 false）
                .setDbColumnUnderline(true)     // 表名、字段名、是否使用下划线命名（默认 false）
                .setEntityBooleanColumnRemoveIsPrefix(true) // Boolean类型字段是否移除is前缀（默认 false）
                .entityTableFieldAnnotationEnable(true)     // 是否生成实体时，生成字段注解
                .setRestControllerStyle(true) // Controller -> RestController
                .setTablePrefix("t_")         // 表前缀
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);    //修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)       // 开启 ActiveRecord 模式
                .setBaseResultMap(true)     // XML BaseResultMap, default: false
                .setBaseColumnList(true)    // XML BaseColumn, default: false
                .setEnableCache(false)      // 是否在XxMapper.xml中添加二级缓存配置, default: true
                .setAuthor("Chris")         // Coding Author
                .setOutputDir("codeGen")    // 当前项目工程根目录下
                .setFileOverride(true)      // 是否覆盖已有文件
                ;
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        new AutoGenerator()
//                .setTemplate(new TemplateConfig().setController(null)) // 不需要生成controller层代码
                .setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                ).execute();
    }
}
