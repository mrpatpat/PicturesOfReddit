
package de.curlse.mrpatpat.picturesofreddit.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;

public class Data {

    @Expose
    private String modhash;
    @Expose
    private List<Child> children = new ArrayList<Child>();
    @Expose
    private String after;
    @Expose
    private Object before;

    public String getModhash() {
        return modhash;
    }

    public void setModhash(String modhash) {
        this.modhash = modhash;
    }

    public Data withModhash(String modhash) {
        this.modhash = modhash;
        return this;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    public Data withChildren(List<Child> children) {
        this.children = children;
        return this;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }

    public Data withAfter(String after) {
        this.after = after;
        return this;
    }

    public Object getBefore() {
        return before;
    }

    public void setBefore(Object before) {
        this.before = before;
    }

    public Data withBefore(Object before) {
        this.before = before;
        return this;
    }

}
