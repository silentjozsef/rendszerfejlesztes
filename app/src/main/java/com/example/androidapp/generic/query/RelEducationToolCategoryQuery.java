package com.example.androidapp.generic.query;

import android.content.Context;

import com.example.androidapp.generic.entity.Education;

public class RelEducationToolCategoryQuery extends BaseQuery<Education> {

    private static final RelEducationToolCategoryQuery query = new RelEducationToolCategoryQuery();

    public static RelEducationToolCategoryQuery get() {
        return query;
    }

    private static final String url = "rel-education-tool-category/";

    private RelEducationToolCategoryQuery() {
        super(url, null);
    }

    private RelEducationToolCategoryQuery(Context context) {
        super(url, context);
    }



    @Override
    public RelEducationToolCategoryQuery setContext(Context context) {
        this.context = context;
        return this;
    }

}
