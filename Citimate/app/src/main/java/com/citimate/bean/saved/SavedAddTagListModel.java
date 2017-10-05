package com.citimate.bean.saved;

public class SavedAddTagListModel {

    private String tagListName = "";
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getTagListName() {
        return tagListName;
    }

    public void setTagListName(String tagListName) {
        this.tagListName = tagListName;
    }
}
