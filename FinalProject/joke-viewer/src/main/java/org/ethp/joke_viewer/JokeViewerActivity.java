package org.ethp.joke_viewer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeViewerActivity extends AppCompatActivity {

    public static String EXTRA_JOKE = "JOKE_EXTRA";

    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_viewer);

        jokeTextView = findViewById(R.id.jokeTextView);

        String joke = getString(R.string.no_joke);

        Intent intent = getIntent();
        if (intent != null) {
            joke = intent.getStringExtra(EXTRA_JOKE);
        }

        jokeTextView.setText(joke);
    }
}
