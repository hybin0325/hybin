package net.medcrm.yjb.workflow.util;

import com.his.mybatis.dynamicDataSource.page.PageInfo;

/**
 * 分页工具
 *
 * @author henryyan
 */
public class PageUtil {

    public static int PAGE_SIZE = 15;

    public static int[] init(PageInfo<?> page, int pageNum,int pageSize) {
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        int firstResult = (pageNum - 1) * pageSize;
        int maxResults = page.getPageSize();
        return new int[]{firstResult, maxResults};
    }

}
