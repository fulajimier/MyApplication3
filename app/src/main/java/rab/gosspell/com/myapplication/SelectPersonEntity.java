package rab.gosspell.com.myapplication;

/**
 * author：lirui on 2017/12/20.
 * todo//
 * version：v1.0
 */

public class SelectPersonEntity {
    String name;
    boolean isCheck;
    String icon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public SelectPersonEntity(String name, boolean isCheck, String icon) {

        this.name = name;
        this.isCheck = isCheck;
        this.icon = icon;
    }
}
