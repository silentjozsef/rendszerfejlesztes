package com.example.androidapp.generic.query;

import android.content.Context;

import com.example.androidapp.generic.entity.Education;

public class RelEducationUserQuery extends BaseQuery<Education> {

    public static RelEducationUserQuery get() {
        RelEducationUserQuery relEducationUserQuery = new RelEducationUserQuery();
        relEducationUserQuery.context = query.context;
        relEducationUserQuery.parentUrl = url;
        relEducationUserQuery.session = query.session;
        return relEducationUserQuery;
    }

    public static RelEducationUserQuery get(Context context) {
        RelEducationUserQuery relEducationUserQuery = new RelEducationUserQuery();
        relEducationUserQuery.context = context;
        relEducationUserQuery.parentUrl = url;
        relEducationUserQuery.session = query.session;
        return relEducationUserQuery;
    }
    private static final String url = "rel-education-user/";

    @Override
    public RelEducationUserQuery setContext(Context context) {
        return (RelEducationUserQuery)super.setContext(context);
    }
}
