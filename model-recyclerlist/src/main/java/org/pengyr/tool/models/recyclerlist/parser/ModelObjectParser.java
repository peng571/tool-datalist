package org.pengyr.tool.models.recyclerlist.parser;


import org.pengyr.tool.models.KeyModel;

/**
 * An implemented class of ObjectRefresher
 *
 * @param <T> object type that extends from DataModel, parse P as ID
 */
public class ModelObjectParser<P, T extends KeyModel<P>> extends ObjectParser<P, T> {

    public P parse(T t) {
        return t.getID();
    }

}
