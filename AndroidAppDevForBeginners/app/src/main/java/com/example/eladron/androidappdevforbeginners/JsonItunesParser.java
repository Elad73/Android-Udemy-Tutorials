package com.example.eladron.androidappdevforbeginners;

import com.example.eladron.androidappdevforbeginners.Model.ItunesStuff;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by eladron on 08/02/2017.
 */

public class JsonItunesParser {

    public static ItunesStuff getItunesStuff (String data) throws JSONException {

        ItunesStuff itunesStuff = new ItunesStuff();

        JSONObject itunesStuffJsonObject = new JSONObject(data);

        JSONArray resultsJsonArray = itunesStuffJsonObject.getJSONArray("results");
        JSONObject artistObject = resultsJsonArray.getJSONObject(0);
        itunesStuff.setType(getString("wrapperType", artistObject));
        itunesStuff.setKind(getString("kind", artistObject));
        itunesStuff.setArtistName(getString("artistName", artistObject));
        itunesStuff.setCollectionName(getString("collectionName", artistObject));
        itunesStuff.setArtistViewURL(getString("artworkUrl100", artistObject));
        itunesStuff.setTrackName(getString("trackName", artistObject));

        return itunesStuff;


    }

    private static JSONObject getJSONObject (String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getJSONObject(tagName);
    }

    private static String getString (String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getString(tagName);
    }

    private static int getInt (String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getInt(tagName);
    }

    private static float getFloat (String tagName, JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }

    private static boolean getBoolean (String tagName, JSONObject jsonObject) throws JSONException {
        return jsonObject.getBoolean(tagName);
    }
}
