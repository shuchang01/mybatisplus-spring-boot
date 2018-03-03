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
        generateByTables(serviceNameStartWithI, packageName, "t_feedback");
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
                .setCapitalMode(true)
//                .setEntityLombokModel(false)
                .setEntityLombokModel(true)
                .setDbColumnUnderline(true)
                .setRestControllerStyle(true) // Controller -> RestController
                .setTablePrefix("t_")
                .setNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames); //修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setBaseResultMap(true) // XML BaseResultMap, default: false
                .setBaseColumnList(true) // XML BaseColumn, default: false
                .setEnableCache(false) // 是否在XxMapper.xml中添加二级缓存配置, default: true
                .setAuthor("Chris")
//                .setOutputDir("d:\\codeGen")
                .setOutputDir("codeGen") // 当前项目工程根目录下
                .setFileOverride(true);
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

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}
