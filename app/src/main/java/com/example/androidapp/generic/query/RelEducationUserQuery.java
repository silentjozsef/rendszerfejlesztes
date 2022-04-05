package com.example.androidapp.generic.query;

import android.content.Context;

import com.example.androidapp.generic.entity.Education;

public class RelEducationUserQuery extends BaseQuery<Education> {

    private static final RelEducationUserQuery query = new RelEducationUserQuery();

    public static RelEducationUserQuery get() {
        return query;
    }

    private static final String url = "rel-education-user/";

    private RelEducationUserQuery() {
        super(url, null);
    }

    private RelEducationUserQuery(Context context) {
        super(url, context);
    }



    @Override
    public RelEducationUserQuery setContext(Context context) {
        this.context = context;
        return this;
    }

}
