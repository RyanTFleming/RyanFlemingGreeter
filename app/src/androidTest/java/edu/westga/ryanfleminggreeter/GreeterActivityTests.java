package edu.westga.ryanfleminggreeter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Test class for the GreeterActivity
 *
 * Created by Ryan on 3/1/2016.
 */
public class GreeterActivityTests extends ActivityInstrumentationTestCase2<GreeterActivity> {

    public GreeterActivityTests() {
     super(GreeterActivity.class);
    }

    public void testActivityExists() {
        GreeterActivity activity = getActivity();
        assertNotNull(activity);
    }

    public void testGreet() {
        GreeterActivity activity = getActivity();
        final EditText nameEditText = (EditText) activity.findViewById(R.id.greet_edit_text);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                nameEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Jake");

        Button greetButton = (Button) activity.findViewById(R.id.greet_button);
        TouchUtils.clickView(this, greetButton);

        TextView greetMessage = (TextView) activity.findViewById(R.id.message_text_view);

        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);

    }
}
