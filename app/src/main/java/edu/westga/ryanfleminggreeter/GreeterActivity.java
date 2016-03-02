package edu.westga.ryanfleminggreeter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GreeterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_greeter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * onClick listener for the greet button. builds the greeting and
     * displays it
     * @param view - the button
     */
    public void didTapGreetButton(View view) {
        EditText greetEditText = (EditText) findViewById(R.id.greet_edit_text);
        String name = greetEditText.getText().toString();
        String greeting = String.format("Hello, %s!", name);
        TextView messageTextView = (TextView) findViewById(R.id.message_text_view);
        messageTextView.setText(greeting);
        Button reverseButton = (Button) findViewById(R.id.reverse_button);
        reverseButton.setEnabled(true);
    }

    /**
     * onClick listenter for the reverse button. Reverses the greeting text
     * @param view - the button
     */
    public void didTapReverseButton(View view) {
        TextView messageTextView = (TextView) findViewById(R.id.message_text_view);
        String greeting = messageTextView.getText().toString();
        StringBuilder greetingBuilder = new StringBuilder(greeting);
        greetingBuilder.reverse();
        String reverseGreeting = greetingBuilder.toString();
        messageTextView.setText(reverseGreeting);
    }
}
