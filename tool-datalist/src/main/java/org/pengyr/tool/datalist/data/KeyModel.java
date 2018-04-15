package org.pengyr.tool.datalist.data;

/**
 * All model to use with DataContainer must implements this interface.
 *
 * @param <K> Type of Primary key, always Integer, Long or String
 */
public interface KeyModel<K> {
    K getID();
}
