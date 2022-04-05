package com.example.androidapp.generic.query;

import android.content.Context;

import com.example.androidapp.generic.entity.Education;
import com.example.androidapp.generic.entity.Tool;

public class EducationQuery extends BaseQuery<Education> {

    private static final EducationQuery query = new EducationQuery();

    public static EducationQuery get() {
        return query;
    }

    private static final String url = "education/";

    private EducationQuery() {
        super(url, null);
    }

    private EducationQuery(Context context) {
        super(url, context);
    }



    @Override
    public EducationQuery setContext(Context context) {
        this.context = context;
        return this;
    }

}
