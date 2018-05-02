package org.pengyr.tool.models.recyclerlist.parser;

/**
 * An implemented class of ObjectRefresher
 *
 * @param <T> object type from server and list
 */
public class BaseObjectParser<T> extends ObjectParser<T, T> {

    public T parse(T t) {
        return t;
    }

}
