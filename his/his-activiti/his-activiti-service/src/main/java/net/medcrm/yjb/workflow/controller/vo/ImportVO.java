package net.medcrm.yjb.workflow.controller.vo;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/1/22.
 */

public class ImportVO implements Serializable{
    private String type;//模块Id
    private String fileName;//文件名
    private String fileBase64;//

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileBase64() {
        return fileBase64;
    }

    public void setFileBase64(String fileBase64) {
        this.fileBase64 = fileBase64;
    }
}
