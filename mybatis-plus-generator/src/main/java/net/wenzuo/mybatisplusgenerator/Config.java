package net.wenzuo.mybatisplusgenerator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.json.JSONUtil;
import de.codeshelf.consoleui.prompt.InputResult;
import de.codeshelf.consoleui.prompt.PromtResultItemIF;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;
import lombok.Data;
import lombok.SneakyThrows;

import java.io.File;
import java.util.HashMap;

/**
 * @author Catch
 * @since 2022-11-07
 */
@Data
public class Config {

    public static Config config = new Config();

    /**
     * 生成路径
     */
    private String outputDir = "generator";
    /**
     * 数据库链接
     */
    private String dataSourceUrl;
    /**
     * 数据库用户名
     */
    private String dataSourceUsername;
    /**
     * 数据库密码
     */
    private String dataSourcePassword;
    /**
     * 公共包名
     */
    private String packageName;
    /**
     * 表名前缀
     */
    private String tablePrefix;
    /**
     * 包含表名(多个以,隔开, 忽略则生成所有表)
     */
    private String tableInclude;
    /**
     * 排除表名(多个以,隔开, 忽略则生成所有表)
     */
    private String tableExclude;

    public static void loadConfig() {
        loadByFile();
        loadByInput();
    }

    @SneakyThrows
    private static void loadByInput() {
        PromptBuilder promptBuilder = Main.PROMPT.getPromptBuilder();
        fillBuilder(promptBuilder, config.getOutputDir(), "outputDir", "生成目录", "./generator");
        fillBuilder(promptBuilder, config.getDataSourceUrl(), "dataSourceUrl", "数据库连接", null);
        HashMap<String, ? extends PromtResultItemIF> map = Main.PROMPT.prompt(promptBuilder.build());
        InputResult outputDir = (InputResult) map.get("outputDir");
        if (outputDir != null) {
            config.setOutputDir(outputDir.getInput());
        }

        InputResult dataSourceUrl = (InputResult) map.get("dataSourceUrl");
        if (dataSourceUrl != null) {
            config.setOutputDir(dataSourceUrl.getInput());
        }
        System.out.println(config);
        map = Main.PROMPT.prompt(promptBuilder.build());
    }

    private static void fillBuilder(PromptBuilder promptBuilder, String field, String name, String message, String defaultValue) {
        if (field == null) {
            promptBuilder.createInputPrompt()
                         .name(name)
                         .message(message)
                         .defaultValue(defaultValue)
                         .addPrompt();
        }
    }

    private static void loadByFile() {
        File file = new File("config.json");
        if (file.exists()) {
            String jsonString = FileUtil.readString("config.json", CharsetUtil.CHARSET_UTF_8);
            config = JSONUtil.toBean(jsonString, Config.class);
        }
    }

}
