package com.example.rxjava_map.export;

/**
 * Created by 48608 on 2018/2/28.
 */

public class ExportTextFileOperator extends ExportOperator{
    @Override
    public ExportFileApi factoryMethod() {
        return new ExportTextFile();
    }
}
