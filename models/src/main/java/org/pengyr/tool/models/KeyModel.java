package org.pengyr.tool.models;

/**
 * All model to use with DataContainer must implements this interface.
 *
 * @param <K> Type of Primary key, could be Integer, Long or String
 */
public interface KeyModel<K> {
    K getID();
}
