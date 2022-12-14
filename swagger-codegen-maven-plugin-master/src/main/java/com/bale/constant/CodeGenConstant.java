package com.bale.constant;

import java.io.File;

public final class CodeGenConstant {

    private CodeGenConstant() {
    }

    public static final String EMPTY_STRING = "";

    public static final String JAVA_SRC_PATH = File.separator + "src" + File.separator + "main" + File.separator + "java";

    public static final String MODEL_TEMPLATE_FILE = "model.mustache";

    public static final String API_TEMPLATE_FILE = "api.mustache";

    public static final String SERVICE_TEMPLATE_FILE = "service.mustache";

    public static final String CONTROLLER_TEMPLATE_FILE = "controller.mustache";
}