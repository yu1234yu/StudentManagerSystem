package com.example.a00687560.model;

import org.litepal.crud.DataSupport;
import org.w3c.dom.Text;

/**
 * Created by 00687560 on 2017/3/27.
 */

public class SearchHistory extends DataSupport {
    private int id;
    private int user_id;
    private String search_name;

    private StudentInfo studentInfo;
}
