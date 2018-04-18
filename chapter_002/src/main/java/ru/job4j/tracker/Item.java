package ru.job4j.tracker;

import java.util.UUID;

public class Item {
    private String id;
    private String name = "";
    private String desc = "";
    private long created = 0;
    private String[] comments;

    public Item(String id) {
        this.id = id;
    }

    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public Item(String id, String name, String desc, long created) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }
}
