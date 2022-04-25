package com.example.androidapp.generic.query;

import android.content.Context;

import com.example.androidapp.generic.entity.Education;

public class RelEducationToolCategoryQuery extends BaseQuery<Education> {

    public static RelEducationToolCategoryQuery get() {
        RelEducationToolCategoryQuery relEducationToolCategoryQuery = new RelEducationToolCategoryQuery();
        relEducationToolCategoryQuery.context = query.context;
        relEducationToolCategoryQuery.parentUrl = url;
        relEducationToolCategoryQuery.session = query.session;
        return relEducationToolCategoryQuery;
    }

    public static RelEducationToolCategoryQuery get(Context context) {
        RelEducationToolCategoryQuery relEducationToolCategoryQuery = new RelEducationToolCategoryQuery();
        relEducationToolCategoryQuery.context = context;
        relEducationToolCategoryQuery.parentUrl = url;
        relEducationToolCategoryQuery.session = query.session;
        return relEducationToolCategoryQuery;
    }

    private static final String url = "rel-education-tool-category/";


    @Override
    public RelEducationToolCategoryQuery setContext(Context context) {
        return (RelEducationToolCategoryQuery)super.setContext(context);
    }
}
