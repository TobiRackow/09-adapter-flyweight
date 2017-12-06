package de.fhro.inf.prg3.a09.model;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

import java.util.Random;

import de.fhro.inf.prg3.a09.R;
import de.fhro.inf.prg3.a09.model.empire.TieBomber;
import de.fhro.inf.prg3.a09.model.empire.TieFighter;
import de.fhro.inf.prg3.a09.model.empire.TieInterceptor;
import de.fhro.inf.prg3.a09.model.rebellion.AWing;
import de.fhro.inf.prg3.a09.model.rebellion.XWing;
import de.fhro.inf.prg3.a09.model.rebellion.YWing;

/**
 * @author Peter Kurfer
 */

public class FighterFactory {

    private final Random random;
    private final Context context;
    private final NameGenerator nameGenerator;

    private FlyweightFactory flyweightFactory;

    public FighterFactory(Context context,FlyweightFactory flyweightFactory) {
        this.context = context;
        nameGenerator = new NameGenerator(context);
        random = new Random();
        this.flyweightFactory = flyweightFactory;
    }

    public Fighter createFighter() {
        switch (random.nextInt(6)) {
            case 0:
                return new AWing(nameGenerator.generateName(), flyweightFactory.getFlyweight(R.drawable.awing,context));
            case 1:
                return new XWing(nameGenerator.generateName(), flyweightFactory.getFlyweight(R.drawable.xwing,context));
            case 2:
                return new YWing(nameGenerator.generateName(), flyweightFactory.getFlyweight(R.drawable.ywing,context));
            case 3:
                return new TieBomber(nameGenerator.generateName(), flyweightFactory.getFlyweight(R.drawable.tiebomber,context));
            case 4:
                return new TieFighter(nameGenerator.generateName(), flyweightFactory.getFlyweight(R.drawable.tiefighter,context));
            default:
                return new TieInterceptor(nameGenerator.generateName(), flyweightFactory.getFlyweight(R.drawable.tieinterceptor,context));
        }
    }

}
