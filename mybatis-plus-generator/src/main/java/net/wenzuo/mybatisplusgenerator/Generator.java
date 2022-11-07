package net.wenzuo.mybatisplusgenerator;

import java.io.File;
import java.util.Scanner;

/**
 * @author Catch
 * @since 2022-11-07
 */
public class Generator {

    /**
     * 读取控制台输入内容
     */
    private final Scanner scanner = new Scanner(System.in);

    // public static void doGenerate() {
    //     System.out.println("======== 开始执行代码生成 ========");
    //     if (Config.config.getOutputDir() == null) {
    //         outputDir = System.getProperty("user.dir") + "/generator";
    //     }
    //     clean(outputDir);
    //
    //     DataSourceConfig.Builder dataSourceBuilder = new DataSourceConfig.Builder(
    //         getRequired(dataSourceUrl, "数据库链接"),
    //         getRequired(dataSourceUsername, "数据库用户名"),
    //         getRequired(dataSourcePassword, "数据库密码"))
    //         .dbQuery(new MySqlQuery())
    //         .typeConvert(new MySqlTypeConvert())
    //         .keyWordsHandler(new MySqlKeyWordsHandler());
    //
    //     FastAutoGenerator.create(dataSourceBuilder)
    //                      // 全局配置
    //                      .globalConfig(builder -> builder.outputDir(outputDir)
    //                                                      .disableOpenDir()
    //                                                      .author("Generator")
    //                                                      .commentDate("yyyy-MM-dd")
    //                      )
    //                      // 包配置
    //                      .packageConfig(builder ->
    //                          builder.parent(getRequired(packageName, "公共包名"))
    //                                 .controller("controller")
    //                                 .service("service")
    //                                 .serviceImpl("service.impl")
    //                                 .mapper("dao")
    //                                 .entity("entity")
    //                                 .pathInfo(Collections.singletonMap(OutputFile.xml, outputDir + "/resource/mapper"))
    //                      )
    //                      .templateEngine(new FreemarkerTemplateEngine())
    //                      // 策略配置
    //                      .strategyConfig(builder -> {
    //                              String input = get(tablePrefix, "表名前缀(多个以,隔开)");
    //                              if (StringUtils.isNotBlank(input)) {
    //                                  builder.addTablePrefix(input.split(","));
    //                              }
    //                              input = get(tableInclude, "包含表名(多个以,隔开, 忽略则生成所有表)");
    //                              if (StringUtils.isNotBlank(input)) {
    //                                  builder.addInclude(input.split(","));
    //                              } else {
    //                                  input = get(tableExclude, "排除表名(多个以,隔开, 忽略则生成所有表)");
    //                                  if (StringUtils.isNotBlank(input)) {
    //                                      builder.addExclude(input.split(","));
    //                                  }
    //                              }
    //
    //                              builder.entityBuilder()
    //                                     .enableLombok()
    //                                     .enableTableFieldAnnotation()
    //                                     .naming(NamingStrategy.underline_to_camel)
    //                                     .columnNaming(NamingStrategy.underline_to_camel)
    //                                     .addTableFills(new Column("create_time", FieldFill.INSERT),
    //                                         new Column("update_time", FieldFill.INSERT_UPDATE))
    //                                     .logicDeleteColumnName("is_deleted")
    //                                     .logicDeletePropertyName("isDeleted");
    //
    //                              builder.mapperBuilder()
    //                                     .convertMapperFileName(name -> name + "Dao");
    //
    //                              builder.serviceBuilder()
    //                                     .convertServiceFileName(name -> name + "Service");
    //
    //                              builder.controllerBuilder()
    //                                     .enableHyphenStyle()
    //                                     .enableRestStyle();
    //                          }
    //                      )
    //                      .execute();
    //
    //     System.out.println("======== 代码生成完成, 生成路径: " + outputDir + " ========");
    // }
    //
    // protected String get(String property, String message) {
    //     if (property == null) {
    //         return nextInput(message);
    //     }
    //     return property;
    // }
    //
    // protected String getRequired(String property, String message) {
    //     if (StringUtils.isBlank(property)) {
    //         return nextInputRequired(message);
    //     }
    //     return property;
    // }
    //
    // /**
    //  * 控制台输入内容读取并打印提示信息
    //  *
    //  * @param message 提示信息
    //  * @return string 用户输入
    //  */
    // protected String nextInputRequired(String message) {
    //     return nextInput(message, true);
    // }
    //
    // /**
    //  * 控制台输入内容读取并打印提示信息
    //  *
    //  * @param message 提示信息
    //  * @return string 用户输入, 可为空
    //  */
    // protected String nextInput(String message) {
    //     return nextInput(message, false);
    // }
    //
    // /**
    //  * 控制台输入内容读取并打印提示信息
    //  *
    //  * @param message  提示信息
    //  * @param required 是否必须输入文字
    //  * @return string 用户输入
    //  */
    // protected String nextInput(String message, boolean required) {
    //     System.out.println("请输入" + message + ":");
    //     String nextLine = scanner.nextLine();
    //     if (required) {
    //         if (StringUtils.isBlank(nextLine)) {
    //             return nextInput(message, required);
    //         }
    //         return nextLine;
    //     }
    //     return nextLine;
    // }

    protected void clean(String dir) {
        File directory = new File(dir);
        if (!directory.exists()) {
            return;
        }
        clean(directory);
    }

    private void clean(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                clean(file);
            }
        }
        if (!dir.delete()) {
            throw new RuntimeException("文件夹清空失败");
        }
    }

}
