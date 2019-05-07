package com.hznu.smartmeeting.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * 代码生成器
 * <p>
 * 参考地址：http://mp.baomidou.com/#/generate-code
 *
 */
public class GeneratorServiceEntity {

    @Test
    public void generateCode() {
        /**
         * 包名
         */
        String packageName = "com.hznu.smartmeeting";
        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService

//        generateByTables(serviceNameStartWithI, packageName, "user",
//                "sign_doc", "sign_req", "archive",
//                "favorite", "org", "template_in", "org_seal_manage",
//                "sys_config", "role_resource", "sys_log", "flow_template_detail",
//                "role", "user_role", "role_resource", "resource");

        generateByTables(serviceNameStartWithI, packageName, "message_record");
    }

    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
        /**
         * 数据库连接路径
         */
        String dbUrl = "jdbc:mysql://localhost:3306/smartmeeting?useUnicode=true&characterEncoding=utf8&useSSL=false";

        /**
         * 数据库账号
         */
        String db_username = "root";
        /**
         * 数据库密码
         */
        String db_pwd = "123456";
        /**
         *
         * 数据库驱动
         */
        String db_driver = "com.mysql.jdbc.Driver";

        AutoGenerator mpg = new AutoGenerator();
        /**
         * 数据库相关配置
         */
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername(db_username)
                .setPassword(db_pwd)
                .setDriverName(db_driver);
        /**
         * 策略相关配置
         */
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false)
                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel) //下划线转化为驼峰
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组

        /**
         * 全局相关配置
         */
        GlobalConfig config = new GlobalConfig();
        config.setActiveRecord(false)
                .setEnableCache(false) //XML二级缓存
                .setAuthor("AppleWld") //设置作者
//                .setOutputDir("src/main/java") //输出目录
                .setOutputDir("generator") //输出目录
                .setFileOverride(true) //文件直接覆盖
                .setMapperName("%sDao") //设置dao层文件名
                .setXmlName("%sMapper");

        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }


        mpg.setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
//                .setCfg(cfg)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setController("controller")
                                .setEntity("entity")
                                .setMapper("dao")
                                .setXml("mapper")

                ).execute();
    }

    private void generateByTables(String packageName, String... tableNames) {
        generateByTables(true, packageName, tableNames);
    }
}
