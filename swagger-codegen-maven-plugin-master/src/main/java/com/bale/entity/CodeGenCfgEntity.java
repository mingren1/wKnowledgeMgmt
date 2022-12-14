package com.bale.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class CodeGenCfgEntity {

    private String modelPackage;

    private String modelTemplate;

    private String apiPackage;

    private String apiTemplate;

    private String servicePackage;
    private String controllerPackage;

    private String serviceTemplate;

    private String controllerTemplate;

    private String outputBasePath;
}
