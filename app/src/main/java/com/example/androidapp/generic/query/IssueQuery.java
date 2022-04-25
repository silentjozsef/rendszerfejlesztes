package com.example.androidapp.generic.query;

import android.content.Context;

import com.example.androidapp.generic.entity.Issue;

public class IssueQuery extends BaseQuery<Issue> {


    public static IssueQuery get() {
        IssueQuery issueQuery = new IssueQuery();
        issueQuery.context = query.context;
        issueQuery.parentUrl = url;
        issueQuery.session = query.session;
        return issueQuery;
    }

    public static IssueQuery get(Context context) {
        IssueQuery issueQuery = new IssueQuery();
        issueQuery.context = context;
        issueQuery.parentUrl = url;
        issueQuery.session = query.session;
        return issueQuery;
    }

    private static final String url = "issue/";

    @Override
    public IssueQuery setContext(Context context) {
        return (IssueQuery) super.setContext(context);
    }

}
