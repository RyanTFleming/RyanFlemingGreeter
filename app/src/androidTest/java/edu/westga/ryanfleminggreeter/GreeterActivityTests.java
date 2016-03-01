package edu.westga.ryanfleminggreeter;

import android.test.ActivityInstrumentationTestCase2;

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
}
