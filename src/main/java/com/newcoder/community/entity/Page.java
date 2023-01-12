package com.newcoder.community.entity;

public class Page {
    //当前页码
    private int current = 1;
    //一页的显示上限
    private int limit = 10;

    //数据总数（用来计算总页数)
    private int rows;
    //查询路径（用于复用分页链接， 就是前端点1就会出现第一页信息， 点3就会出现第三页信息）
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current>1)
            this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if(limit>=1 && limit<=100)
            this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows>=0)
            this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    //获取当前页的起始行
    public int getOffset(){
        //current * limit - limit
        return (current-1) * limit;

    }
    //获取总页数
    public int getTotal(){
        //rows / limit [+1]
        if(rows%limit==0)
            return rows/limit;
        else
            return rows/limit+1;

    }

    /**
     * 获取起始页码
     *
     * @return
     */
    public int getFrom() {
        int from = current - 2;
        return from < 1 ? 1 : from;
    }

    /**
     * 获取结束页码
     *
     * @return
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return to > total ? total : to;
    }

    @Override
    public String toString() {
        return "Page{" +
                "current=" + current +
                ", limit=" + limit +
                ", rows=" + rows +
                ", path='" + path + '\'' +
                '}';
    }
}
