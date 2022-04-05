package com.example.androidapp.generic.query;

import android.content.Context;

import com.example.androidapp.generic.entity.Tool;

public class ToolCategoryQuery extends BaseQuery<Tool> {

    private static final ToolCategoryQuery query = new ToolCategoryQuery();

    public static ToolCategoryQuery get() {
        return query;
    }

    private static final String url = "tool-category/";

    private ToolCategoryQuery() {
        super(url, null);
    }

    private ToolCategoryQuery(Context context) {
        super(url, context);
    }



    @Override
    public ToolCategoryQuery setContext(Context context) {
        this.context = context;
        return this;
    }

}
