package com.edas.business.data.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LicenseData implements Serializable {
    private  String license;
    private  List<CarcusInfo> carcusInfo;
}
