package wechat.model;

/**
 * 别墅设备里的图标
 */
public class Icon {
    private int id;//编号
    private String content;//内容
    private String imgPath;//图标路径
    private boolean isShow=false;//是否显示

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }
}
