package es.unex.giiis.golaso;


import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.DataInteraction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TestCU04_Ajustes {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testCU04_Ajustes() throws InterruptedException {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edit_user),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("fe"), closeSoftKeyboard());
        Thread.sleep(1000);
        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.edit_user), withText("fe"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText2.perform(click());
        Thread.sleep(1000);
        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.edit_password),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("uio"), closeSoftKeyboard());
        Thread.sleep(1000);
        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.edit_user), withText("fe"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("ferrrrr"));
        Thread.sleep(1000);
        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.edit_user), withText("ferrrrr"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText5.perform(closeSoftKeyboard());
        Thread.sleep(1000);
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.btn_login), withText("Iniciar sesión"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                2),
                        isDisplayed()));
        materialButton.perform(click());
        Thread.sleep(1000);
        ViewInteraction overflowMenuButton = onView(
                allOf(withContentDescription("Más opciones"),
                        childAtPosition(
                                childAtPosition(
                                        withId(com.bumptech.glide.R.id.action_bar),
                                        1),
                                0),
                        isDisplayed()));
        overflowMenuButton.perform(click());
        Thread.sleep(1000);
        ViewInteraction materialTextView = onView(
                allOf(withId(androidx.recyclerview.R.id.title), withText("Ajustes"),
                        childAtPosition(
                                allOf(withId(com.bumptech.glide.R.id.content),
                                        childAtPosition(
                                                withClassName(is("androidx.appcompat.view.menu.ListMenuItemView")),
                                                1)),
                                0),
                        isDisplayed()));
        materialTextView.perform(click());
        Thread.sleep(1000);
        ViewInteraction recyclerView = onView(
                allOf(withId(androidx.preference.R.id.recycler_view),
                        childAtPosition(
                                withId(android.R.id.list_container),
                                0)));
        recyclerView.perform(actionOnItemAtPosition(7, click()));
        Thread.sleep(1000);
        DataInteraction appCompatCheckedTextView = onData(anything())
                .inAdapterView(allOf(withId(com.bumptech.glide.R.id.select_dialog_listview),
                        childAtPosition(
                                withId(com.bumptech.glide.R.id.contentPanel),
                                0)))
                .atPosition(1);
        appCompatCheckedTextView.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
