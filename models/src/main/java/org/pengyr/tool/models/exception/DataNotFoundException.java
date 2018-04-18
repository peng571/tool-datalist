package org.pengyr.tool.models.exception;

/**
 * Created by Peng on 2018/4/15.
 */
public class DataNotFoundException extends Throwable {


    /**
     * Throw when not find value in container
     *
     * @param message String.value(id)
     */
    public DataNotFoundException(String message) {
        super("can not find id [" + message + "] on data manager");
    }
}
