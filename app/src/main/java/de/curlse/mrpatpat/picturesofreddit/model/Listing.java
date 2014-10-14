
package de.curlse.mrpatpat.picturesofreddit.model;

import com.google.gson.annotations.Expose;

public class Listing {

    @Expose
    private String kind;
    @Expose
    private Data data;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Listing withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Listing withData(Data data) {
        this.data = data;
        return this;
    }

}
