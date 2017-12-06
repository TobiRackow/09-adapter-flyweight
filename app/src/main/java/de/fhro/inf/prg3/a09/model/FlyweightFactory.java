package de.fhro.inf.prg3.a09.model;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tobi on 06.12.2017.
 */

public class FlyweightFactory {

    private Map<Integer, Drawable> flyweights = new HashMap<>();

    Drawable getFlyweight(int imageId, Context context) {
        if (flyweights.containsKey(imageId))
            return flyweights.get(imageId);

            // allocate new flyweight
            Drawable image = loadImage(imageId,context);
            flyweights.put(imageId, image);
            return image;
        }

    private Drawable loadImage(int imageId, Context context) {
        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeResource(context.getResources(), imageId));
    }
}
