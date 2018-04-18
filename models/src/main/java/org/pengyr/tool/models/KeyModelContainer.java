package org.pengyr.tool.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.ArrayMap;

import org.pengyr.tool.models.exception.DataNotFoundException;

import java.util.Collection;


/**
 * Key Model Container, include add, get, delete methods for CRUD
 * <p>
 * should use instance decide
 * ```
 * private static KeyModelContainer instance = null;
 * <p>
 * public synchronized static KeyModelContainer get() {
 * if (instance == null) {
 * instance = new KeyModelContainer();
 * }
 * return instance;
 * }
 * private KeyModelContainer(){}
 * ```
 * <p>
 * use array map here, so update min android sdk to 19
 *
 * @param <K> Type of Key
 * @param <M> Type of Object must extends DataItem<P>
 */
public class KeyModelContainer<K, M extends KeyModel<K>> {

    protected ArrayMap<K, M> objectDict; // post id : PostObject

    /**
     * should use instance decide for KeyModelContainer,
     * so keep constructor protected or private
     */
    protected KeyModelContainer() {
        objectDict = new ArrayMap<>();
    }


    /**
     * Check is ID in container
     *
     * @param ID key
     * @return true if has this key in container, else false
     */
    public synchronized boolean has(@NonNull K ID) {
        synchronized (this) {
            return objectDict.containsKey(ID);
        }
    }

    /**
     * Get model in container by key
     *
     * @param ID Key
     * @return model
     * @throws DataNotFoundException if not found
     */
    @NonNull public synchronized M get(@NonNull K ID) throws DataNotFoundException {
        synchronized (this) {
            if (!objectDict.containsKey(ID)) {
                throw new DataNotFoundException(ID.toString());
            }
            return objectDict.get(ID);
        }
    }

    /**
     * Get model in container by key
     *
     * @param ID            key
     * @param defaultObject will return this if not find,
     *                      allow default object to be nullable,
     *                      that you should handle NPE event by yourself.
     * @return model if hind, else return default object
     */
    public synchronized M get(@NonNull K ID, @Nullable M defaultObject) {
        try {
            return get(ID);
        } catch (DataNotFoundException e) {
            return defaultObject;
        }
    }


    /**
     * Add object into container.
     *
     * @param object        added object.
     * @param addIfNotExist only add when data is not exist (default is false)
     */
    public synchronized void add(@NonNull M object, boolean addIfNotExist) {
        synchronized (this) {
            if (addIfNotExist && has(object.getID())) return;
            objectDict.put(object.getID(), object);
        }
    }


    public synchronized void add(@NonNull M object) {
        synchronized (this) {
            objectDict.put(object.getID(), object);
        }
    }


    /**
     * Add objects into container
     *
     * @param objects added objects
     */
    public synchronized void add(@NonNull Collection<M> objects) {
        synchronized (this) {
            for (M object : objects) {
                add(object);
            }
        }
    }


    /**
     * Delete object in container by id
     *
     * @param ID key
     */
    public synchronized void delete(@NonNull K ID) {
        synchronized (this) {
            objectDict.remove(ID);
        }
    }

    public synchronized void delete(@NonNull M object) {
        synchronized (this) {
            delete(object.getID());
        }
    }

    /**
     * @return container size
     */
    public synchronized int size() {
        return objectDict.values().size();
    }


    /**
     * clear all data in container
     */
    public void clear() {
        objectDict.clear();
    }
}


