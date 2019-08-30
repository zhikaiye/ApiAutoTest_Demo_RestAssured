package com.kk.wework;

public class WeWorkConfig {

    public String corpid = "ww2229f9605677cec3";
    public String secret = "1ebUc5Dz7hk8FC9ag42vxKSdZyIFLNPyqw03JYbnT3I";
    public String check_sectet = "cl7yDbn6KalQfiVYXd1DpOOsX23PZBNsOVG7GpwFshk";

    private static WeWorkConfig weWorkConfig;
    public static WeWorkConfig getInstance(){
        if (weWorkConfig==null){
            weWorkConfig=new WeWorkConfig();
        }
        return weWorkConfig;
    }

    public static void load(String path){
        //todo:from yml or json
    }
}
