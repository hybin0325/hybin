package com.edas.system.auth.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.edas.system.auth.entity.dto.LoginUser;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserUtil {

	public static LoginUser getLoginUser() {
		System.out.println("getLoginUser {} ========");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		log.info("authentication "+authentication);
		if (authentication != null) {
			if (authentication instanceof AnonymousAuthenticationToken) {
				return null;
			}
			
			log.info("authentication.getPrincipal "+ authentication.getPrincipal());

			if (authentication instanceof UsernamePasswordAuthenticationToken) {
				return (LoginUser) authentication.getPrincipal();
			}
		}

		return null;
	}
	
	public static String getCurrentUserUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
             currentUserName = authentication.getName();
        }
        return currentUserName;
    }


}
