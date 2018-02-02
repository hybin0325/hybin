package net.medcrm.yjb.workflow.config.security;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class RichUserPrincipalExtractor implements PrincipalExtractor {
    public RichUserPrincipalExtractor() {
    }

    public Object extractPrincipal(Map<String, Object> map) {
        RichUserDetails richUserDetails = new RichUserDetails();

        try {
            BeanUtils.populate(richUserDetails, map);
            return richUserDetails;
        } catch (InvocationTargetException | IllegalAccessException var4) {
            throw new RuntimeException(var4);
        }
    }
}
