package cn.yodes.open.crawler.domain;

/**
 * <pre>
 * <p>Description: //TODO</p>
 * <p>Copyright (c) 2017 open.yodes.cn Inc. All rights reserved.</p>
 * </pre>
 *
 * @author Yodes Yang
 * @created 2018/3/29 19:52
 */
public class AuthorEntity {

    private int id;

    private String authorName;

    private String dynasty;

    private String poemNum;

    private String summary;

    private String picRoute;

    public AuthorEntity() {
    }

    public AuthorEntity(int id, String authorName, String dynasty, String poemNum, String summary, String picRoute) {
        this.id = id;
        this.authorName = authorName;
        this.dynasty = dynasty;
        this.poemNum = poemNum;
        this.summary = summary;
        this.picRoute = picRoute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getPoemNum() {
        return poemNum;
    }

    public void setPoemNum(String poemNum) {
        this.poemNum = poemNum;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPicRoute() {
        return picRoute;
    }

    public void setPicRoute(String picRoute) {
        this.picRoute = picRoute;
    }

    @Override
    public String toString() {
        return "AuthorEntity{" +
                "id=" + id +
                ", authorName='" + authorName + '\'' +
                ", dynasty='" + dynasty + '\'' +
                ", poemNum='" + poemNum + '\'' +
                ", summary='" + summary + '\'' +
                ", picRoute='" + picRoute + '\'' +
                '}';
    }
}
