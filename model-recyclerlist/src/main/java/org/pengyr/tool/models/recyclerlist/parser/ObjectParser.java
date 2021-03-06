package org.pengyr.tool.models.recyclerlist.parser;

import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * @param <L> object in list
 * @param <S> object type from server
 */
public abstract class ObjectParser<L, S> {

    private final static String TAG = ObjectParser.class.getSimpleName();

    @Nullable
    @SuppressWarnings("unchecked")
    public List<L> parseResponse(Response response) {
        if (response == null) return null;

        Response<List<S>> parseResponse;
        try {
            parseResponse = (Response<List<S>>) response;
        } catch (Exception e) {
            return null;
        }

        List<S> list = parseResponse.body();
        if (list == null) return null;

        List<L> result = new ArrayList<>();
        for (S s : list) {
            L l = parse(s);
            if (l != null) {
                result.add(l);
            }
        }
        return result;
    }

    /**
     * @param s item in list
     * @return T parse item to what list want, return null to ignore this item from list
     */
    public abstract L parse(S s);

}