package com.example.a00687560.model;

import org.litepal.crud.DataSupport;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 00687560 on 2017/3/27.
 */

public class LibsType extends DataSupport {
    private int id;
    private Text type_name;

    private List<StudentInfo> StudentInfotList = new ArrayList<StudentInfo>();
    private List<LibsInfo> LibsInfoList = new ArrayList<LibsInfo>();
}
