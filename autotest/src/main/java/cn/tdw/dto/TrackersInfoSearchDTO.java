package cn.tdw.dto;

/**
 * 可分配/移交人员列表查询DTO
 * Created by yaodingguo on 2017/8/17.
 */
public class TrackersInfoSearchDTO {
    private String name;//用户名
    private String nickName;
    private Integer page;//页数
    private Integer limit;//每页条数

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
