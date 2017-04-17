package com.liveneo.etrepair.json.wrapper;

public class DropDownModel {
    private String  id;
    private String  text;
    private boolean selected = false;

    public DropDownModel() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DropDownModel(String id, String text) {
        super();
        this.id = id;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
