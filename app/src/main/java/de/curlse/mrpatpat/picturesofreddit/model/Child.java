
package de.curlse.mrpatpat.picturesofreddit.model;

import com.google.gson.annotations.Expose;

public class Child {

    @Expose
    private String kind;
    @Expose
    private Data_ data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Child withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public Data_ getData() {
        return data;
    }

    public void setData(Data_ data) {
        this.data = data;
    }

    public Child withData(Data_ data) {
        this.data = data;
        return this;
    }

}
