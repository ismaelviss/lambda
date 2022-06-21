package org.ismaelviss.userSearch.dto;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class User {

    private List<Datum> data;
    @SerializedName("total")
    private long total;
    @SerializedName("page")
    private long page;
    @SerializedName("limit")
    private long limit;

    public List<Datum> getData() {
        return data;
    }

    public long getTotal() {
        return total;
    }

    public long getPage() {
        return page;
    }

    public long getLimit() {
        return limit;
    }

    @Override
    public String toString() {
        return "User{" +
                "data=" + data +
                ", total=" + total +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }
}

