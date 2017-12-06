package de.fhro.inf.prg3.a09;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import de.fhro.inf.prg3.a09.model.FighterFactory;
import de.fhro.inf.prg3.a09.adapter.FighterListAdapter;
import de.fhro.inf.prg3.a09.model.FlyweightFactory;

public class MainActivity extends AppCompatActivity {

    private static final int FIGHTER_COUNT = 80;
    public FlyweightFactory flyweightFactory = new FlyweightFactory();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FighterFactory fighterFactory = new FighterFactory(this,flyweightFactory);
        FighterListAdapter fighterListAdapter = new FighterListAdapter(this);

        final ListView fighterListView = findViewById(R.id.fighter_list_view);
        fighterListView.setAdapter(fighterListAdapter);

        for (int i = 0; i < FIGHTER_COUNT; i++) {
            fighterListAdapter.add(fighterFactory.createFighter());
        }
    }
}
