package nyc.c4q.mustafizurmatin.rickandportyapi.models;

/**
 * Created by c4q on 3/16/18.
 */

public class InfoBean {

    private int count;
    private int pages;
    private String next;
    private String prev;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrev() {
        return prev;
    }

    public void setPrev(String prev) {
        this.prev = prev;
    }

}
