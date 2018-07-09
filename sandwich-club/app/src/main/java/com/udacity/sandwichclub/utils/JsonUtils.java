package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        // Example json format from log cat
        // {
        // "name":{
        //     "mainName":"Ham and cheese sandwich",
        //     "alsoKnownAs":[]
        // },
        // "placeOfOrigin":" ",
        // "description":"A ham and cheese sandwich is a common type of sandwich. It is made by putting cheese and sliced ham between two slices of bread. The bread is sometimes buttered and/or toasted. Vegetables like lettuce, tomato, onion or pickle slices can also be included. Various kinds of mustard and mayonnaise are also common.",
        // "image":"https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/Grilled_ham_and_cheese_014.JPG/800px-Grilled_ham_and_cheese_014.JPG",
        // "ingredients":["Sliced bread","Cheese","Ham"]
        // }


        Sandwich mySandwich = new Sandwich(); //Create a empty sandwich object.


        /* parse JSON */
        JSONObject myJSONObj = new JSONObject(json); //Initialize JSONObject from JSON string.
        JSONObject name = myJSONObj.getJSONObject("name"); //get the name from JSONObject

        String mySandwichName = name.getString("mainName");

        JSONArray temp = name.getJSONArray("alsoKnownAs");

        List<String> res = new ArrayList<>();

        for (int i = 0; i < temp.length(); i++) {
            res.add(String.valueOf(temp.get(i)));
        }

        JSONArray temp2 = myJSONObj.getJSONArray("ingredients");

        List<String> res2 = new ArrayList<>();

        for (int i = 0; i < temp2.length(); i++) {
            res2.add(String.valueOf(temp2.get(i)));
        }


        /* Update sandwich info */
        mySandwich.setMainName(mySandwichName);

        mySandwich.setAlsoKnownAs(res);

        mySandwich.setIngredients(res2);

        mySandwich.setPlaceOfOrigin(myJSONObj.getString("placeOfOrigin"));

        mySandwich.setDescription(myJSONObj.getString("description"));

        mySandwich.setImage(myJSONObj.getString("image"));


        return mySandwich; // return a Sandwich object with information we got from the json string.


    }
}
