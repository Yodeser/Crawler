package cn.yodes.open.crawler.dal;

import cn.yodes.open.crawler.domain.ThreadEntity;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/11/22
 */
public interface ThreadDao {
    /**
     * 插入帖子
     *
     * @param threadEntity 帖子实体
     * @return 是否成功
     */
    int insert(ThreadEntity threadEntity);

}
