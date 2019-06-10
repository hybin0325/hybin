package com.edas.business.qywechat.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LicenseData implements Serializable {
    private  String license;
    private  List<CarcusInfo> carcusInfo;
}
