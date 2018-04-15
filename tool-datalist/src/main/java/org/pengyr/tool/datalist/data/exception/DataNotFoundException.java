package org.pengyr.tool.datalist.data.exception;

/**
 * Created by Peng on 2018/4/15.
 */
public class DataNotFoundException extends Throwable {

    public DataNotFoundException(String message) {
        super("can not find id [" + message + "] on data manager");
    }
}
