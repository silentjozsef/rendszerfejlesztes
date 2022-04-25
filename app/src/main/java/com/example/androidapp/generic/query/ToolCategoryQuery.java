package com.example.androidapp.generic.query;

import android.content.Context;

import com.example.androidapp.generic.entity.Tool;

public class ToolCategoryQuery extends BaseQuery<Tool> {

    public static ToolCategoryQuery get() {
        ToolCategoryQuery toolCategoryQuery = new ToolCategoryQuery();
        toolCategoryQuery.context = query.context;
        toolCategoryQuery.parentUrl = url;
        toolCategoryQuery.session = query.session;
        return toolCategoryQuery;
    }

    public static ToolCategoryQuery get(Context context) {
        ToolCategoryQuery toolCategoryQuery = new ToolCategoryQuery();
        toolCategoryQuery.context = context;
        toolCategoryQuery.parentUrl = url;
        toolCategoryQuery.session = query.session;
        return toolCategoryQuery;
    }

    private static final String url = "tool-category/";

    @Override
    public ToolCategoryQuery setContext(Context context) {
        return (ToolCategoryQuery)super.setContext(context);
    }
}
