package org.pengyr.tool.datalist.data;

import android.support.annotation.NonNull;
import android.util.ArrayMap;

import org.pengyr.tool.datalist.data.exception.DataNotFoundException;

import java.util.List;


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

    private final static String TAG = KeyModelContainer.class.getSimpleName();


    protected ArrayMap<K, M> objectDict; // post id : PostObject

    protected KeyModelContainer() {
        objectDict = new ArrayMap<>();
    }

    public synchronized boolean hasObject(@NonNull K ID) {
        synchronized (this) {
            return objectDict.containsKey(ID);
        }
    }


    public synchronized M getObject(@NonNull K ID) throws DataNotFoundException {
        synchronized (this) {
            if (!objectDict.containsKey(ID)) {
                throw new DataNotFoundException(ID.toString());
            }
            return objectDict.get(ID);
        }
    }

    @NonNull public synchronized M getObject(@NonNull K ID, @NonNull M defaultObject) {
        try {
            return getObject(ID);
        } catch (DataNotFoundException e) {
            return defaultObject;
        }
    }


    public synchronized void addObject(@NonNull M object) {
        synchronized (this) {
            object.getID();
            objectDict.put(object.getID(), object);
        }
    }


    public synchronized void addObjects(@NonNull List<M> objects) {
        synchronized (this) {
            for (M object : objects) {
                addObject(object);
            }
        }
    }

    public synchronized void deleteObject(@NonNull M ID) {
        synchronized (this) {
            objectDict.remove(ID);
        }
    }

    public void clear() {
        objectDict.clear();
    }
}


