package freemarker.strategy.impl;


import freemarker.strategy.GenerateStrategy;
import freemarker.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 实体repository代码生成策略
 *
 * @author JinGuiBo
 * @date 2018/7/4.
 */
@SuppressWarnings("unchecked")
public class EntityRepositoryStrategy extends GenerateStrategy {

    private final String CHARSET = "utf-8";
    private final Integer BUFFER_SIZE = 1024;

    public EntityRepositoryStrategy(Class clazz,Map<String, String> parame) {
        this.clazz = clazz;
        this.parame = parame;
    }

    @Override
    public void configParame() {
        // 简单类名
        String className = clazz.getSimpleName();
        // 文件构建前缀
        String pathPrefix = parame.get("basePath");
        // 使用模板文件
        String templateName = "EntityRepository.ftl";
        // 业务模块名
        String module = parame.get("module");
        String modulePackage = "";
        if (!StringUtils.isEmpty(module)) {
            modulePackage = "." + module;
            module = StringUtils.replaceToPath(module) + "/";
        }

        String fileName ="/" + module + "I" + className + "EntityRepository.java";
        String packageName = StringUtils.replaceToPath(parame.get("basePackage") + ".dao.repository");

        String filePath = "dao/src/main/java/" + packageName + fileName;

        Map map = new HashMap(2);
        map.put("module", modulePackage);
        map.put("className", className);
        map.put("project", parame.get("project"));

        // 执行模板,生成java文件
        executeTemple(templateName, filePath, map, CHARSET, BUFFER_SIZE);
    }

}
