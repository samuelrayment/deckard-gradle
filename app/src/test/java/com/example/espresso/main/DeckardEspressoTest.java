package com.example.espresso.main;

import android.support.test.espresso.action.ViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import com.example.R;
import com.example.main.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollToPosition;
import static android.support.test.espresso.contrib.RecyclerViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@LargeTest
public class DeckardEspressoTest extends ActivityInstrumentationTestCase2<MainActivity> {

    @SuppressWarnings("deprecation")
     public DeckardEspressoTest() {
       // This constructor was deprecated - but we want to support lower API levels.
       super("com.example.activity", MainActivity.class);
     }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        // Espresso will not launch our activity for us, we must launch it via getActivity().
        getActivity();
    }

    public void testCheckText() {
        onView(withId(R.id.text))
            .check(matches(withText("Hello Espresso!")));
    }

    public void testCheckButtonUpdatesLabel() {
        onView(withId(R.id.button))
            .perform(click());
        onView(withId(R.id.text))
            .check(matches(withText("Button Clicked!")));
    }

    public void testCounterStartsAt() {
        onView(withId(R.id.counter_text))
                .check(matches(withText("4")));
    }

    public void testIncrementingCounter() {
        onView(withId(R.id.increment_button))
                .perform(click());
        onView(withId(R.id.increment_button))
                .perform(click());
        onView(withId(R.id.increment_button))
                .perform(click());

        onView(withId(R.id.counter_text))
                .check(matches(withText("7")));
    }

    public void testDecrementingCounter() {
        onView(withId(R.id.decrement_button))
                .perform(click());
        onView(withId(R.id.decrement_button))
                .perform(click());
        onView(withId(R.id.decrement_button))
                .perform(click());

        onView(withId(R.id.counter_text))
                .check(matches(withText("1")));
    }

    public void testCyclingThroughRecyclerView() {
        for (int i=0; i<8; i++) {
            // Add some more items so we can scroll
            onView(withId(R.id.increment_button))
                    .perform(click());
        }

        onView(withId(R.id.recycler_view))
                .perform(scrollToPosition(8));
        onView(withText("8"))
                .check(matches(isDisplayed()));
    }
}
