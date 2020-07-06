package domain;

public class PageBean {
    private int size;    // 记录条数
    private int row;     // 每页展示数目
    private int pageSize;// 页面总数
    private int current; // 目前页面

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public PageBean() {
    }

    public PageBean(int row, int pageSize) {
        this.row = row;
        this.pageSize = pageSize;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
