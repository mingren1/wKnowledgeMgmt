package com.bale.codegen;

import com.bale.entity.CodeGenCfgEntity;
import io.swagger.codegen.languages.JavaClientCodegen;

public class JavaxRsServerCodeGen extends JavaClientCodegen {

    private String servicePackage = "";
    private String controllerPackage = "";

    public JavaxRsServerCodeGen(CodeGenCfgEntity codeGenCfg) {
        this.outputFolder = codeGenCfg.getOutputBasePath();
        this.apiPackage = codeGenCfg.getApiPackage();
        this.modelPackage = codeGenCfg.getModelPackage();
        this.servicePackage = codeGenCfg.getServicePackage();
        this.controllerPackage = codeGenCfg.getControllerPackage();
    }

    public String servicePackage() {
        return servicePackage;
    }
    public String controllerPackage() {
        return controllerPackage;
    }
}
