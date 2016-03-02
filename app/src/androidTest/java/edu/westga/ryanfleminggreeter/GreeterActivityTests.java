package edu.westga.ryanfleminggreeter;

import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        final GreeterActivity activity = this.getActivity();

        this.clickGreetButton(activity);

        TextView greetMessage = (TextView) activity.findViewById(R.id.message_text_view);

        String actualText = greetMessage.getText().toString();
        assertEquals("Hello, Jake!", actualText);
    }

    /**
     * Tests that the Reverse button is disabled before the Greet button is clicked
     */
    public void testReverseButtonDisabled() {
        GreeterActivity activity = this.getActivity();
        Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);
        assertFalse(reverseButton.isEnabled());
    }

    public void testReverseButtonEnabledAfterGreetClick() {
        GreeterActivity activity = this.getActivity();
        this.clickGreetButton(activity);
        Button reverseButton = (Button) activity.findViewById(R.id.reverse_button);
        assertTrue(reverseButton.isEnabled());
    }


    private void clickGreetButton(GreeterActivity activity) {
        final EditText nameEditText = (EditText) activity.findViewById(R.id.greet_edit_text);
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                nameEditText.requestFocus();
            }
        });
        getInstrumentation().waitForIdleSync();
        getInstrumentation().sendStringSync("Jake");
        getInstrumentation().waitForIdleSync();


        Button greetButton = (Button) activity.findViewById(R.id.greet_button);
        TouchUtils.clickView(this, greetButton);
    }
}
