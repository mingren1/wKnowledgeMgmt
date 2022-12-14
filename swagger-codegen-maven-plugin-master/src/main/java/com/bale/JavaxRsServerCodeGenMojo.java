package com.bale;

import com.bale.codegen.JavaxRsServerCodeGen;
import com.bale.entity.CodeGenCfgEntity;
import com.bale.generator.JavaxRsServerCodeGenerator;
import io.swagger.codegen.ClientOptInput;
import io.swagger.codegen.ClientOpts;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerParser;
import org.apache.commons.io.FileUtils;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static com.bale.constant.CodeGenConstant.API_TEMPLATE_FILE;
import static com.bale.constant.CodeGenConstant.JAVA_SRC_PATH;
import static com.bale.constant.CodeGenConstant.MODEL_TEMPLATE_FILE;
import static com.bale.constant.CodeGenConstant.SERVICE_TEMPLATE_FILE;
import static com.bale.constant.CodeGenConstant.CONTROLLER_TEMPLATE_FILE;

@Mojo(name = "codegen", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class JavaxRsServerCodeGenMojo extends AbstractMojo
{
    @Parameter(readonly=true, required=true, defaultValue="${project}")
    private MavenProject mvnProject; // 当前maven工程, 只读

    @Parameter(name = "inputSpec", property = "inputSpec", required = false)
    private String inputSpec; // open-api文件路径

    @Parameter(name = "apiPackage", property = "apiPackage", defaultValue = "com.codegen.api")
    private String apiPackage; // 生成API接口类包名

    @Parameter(name = "modelPackage", property = "modelPackage", defaultValue = "com.codegen.model")
    private String modelPackage; // 生成模型类包名

    @Parameter(name = "servicePackage", property = "servicePackage", defaultValue = "com.codegen.service")
    private String servicePackage; // 生成服务类包名
    @Parameter(name = "controllerPackage", property = "controllerPackage", defaultValue = "com.codegen.controller")
    private String controllerPackage; // 生成服务类包名

    public void execute() throws MojoExecutionException {
        // 未指定api文件, 使用默认值
        this.inputSpec = Optional.ofNullable(this.inputSpec).orElse("/src/main/resources/open-api.yaml");

        // 清理前一次编译生成的类文件
        this.clearOldFile();

        // 创建swagger对象
        Swagger swagger = this.createSwagger();

        // 生成Java类
        this.generateJavaClass(swagger);
    }

    private void clearOldFile() throws MojoExecutionException {
        try {
            String canonicalPath = this.mvnProject.getBasedir().getCanonicalPath();
            String oldFilePath = canonicalPath + JAVA_SRC_PATH;
            File file = new File(oldFilePath);
            if (file.exists()) {
                FileUtils.cleanDirectory(file);
            }
        } catch (IOException e) {
            throw new MojoExecutionException("Clear old generate file exception!");
        }
    }

    private Swagger createSwagger() throws MojoExecutionException {
        String apiFileStr;
        try {
            File file = new File(this.inputSpec);
            apiFileStr = FileUtils.readFileToString(file, StandardCharsets.UTF_8).trim();
        } catch (IOException e) {
            throw new MojoExecutionException("Read api file to string exception!");
        }

        return new SwaggerParser().parse(apiFileStr);
    }

    private void generateJavaClass(Swagger swagger) throws MojoExecutionException {
        String outputBaseFilePath;
        try {
            String canonicalPath = this.mvnProject.getBasedir().getCanonicalPath();
            outputBaseFilePath = canonicalPath + JAVA_SRC_PATH;
        } catch (IOException e) {
            throw new MojoExecutionException("Generate model file exception!");
        }

        final CodeGenCfgEntity codeGenConfig = CodeGenCfgEntity.builder()
                .apiPackage(apiPackage)
                .apiTemplate(API_TEMPLATE_FILE)
                .modelPackage(modelPackage)
                .modelTemplate(MODEL_TEMPLATE_FILE)
                .servicePackage(servicePackage)
                .controllerPackage(controllerPackage)
                .serviceTemplate(SERVICE_TEMPLATE_FILE)
                .controllerTemplate(CONTROLLER_TEMPLATE_FILE)
                .outputBasePath(outputBaseFilePath)
                .build();

        JavaxRsServerCodeGen javaxRsServerCodeGen = new JavaxRsServerCodeGen(codeGenConfig);
        ClientOptInput clientOptInput = new ClientOptInput().opts(new ClientOpts()).swagger(swagger);
        clientOptInput.setConfig(javaxRsServerCodeGen);

        JavaxRsServerCodeGenerator javaCodeGenerator = new JavaxRsServerCodeGenerator();
        javaCodeGenerator.opts(clientOptInput).generate();
    }
}