package cn.yodes.open.crawler.domain;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2018 yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @since 2018/11/19
 */
public class ThreadEntity {
    private int tid;
    private String title;
    private String content;
    private String updateTime;
    private String type;
    private String source;

    @Override
    public String toString() {
        return "ThreadEntity{" +
                "tid=" + tid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", type=" + type +
                '}';
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
