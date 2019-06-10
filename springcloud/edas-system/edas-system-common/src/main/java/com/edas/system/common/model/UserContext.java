package com.edas.system.common.model;

public class UserContext {
	private static ThreadLocal<CurrentUser> threadLocal = new ThreadLocal<>();

    public static CurrentUser current() {
        return threadLocal.get();
    }

    public static String currentUserName() {
    	CurrentUser userInfo = threadLocal.get();
        if (userInfo!=null) {
            return userInfo.getUsername();
        }
        return null;
    }

    public static void setUserInfo(CurrentUser userInfo) {
        threadLocal.set(userInfo);
    }
}
