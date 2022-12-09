package es.unex.giiis.golaso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

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
public class TestCU05_BuscarEquipo {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testCU05_BuscarEquipo() throws InterruptedException {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edit_user),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("fer"), closeSoftKeyboard());
        Thread.sleep(1000);
        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.edit_password),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("fff"), closeSoftKeyboard());
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
        ViewInteraction bottomNavigationItemView = onView(
                allOf(withId(R.id.nav_buscar), withContentDescription("Buscar"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0),
                                2),
                        isDisplayed()));
        bottomNavigationItemView.perform(click());
        Thread.sleep(1000);
        ViewInteraction tabView = onView(
                allOf(withContentDescription("Buscar equipo"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.buscarTabLayout),
                                        0),
                                1),
                        isDisplayed()));
        tabView.perform(click());
        Thread.sleep(1000);
        ViewInteraction searchAutoComplete = onView(
                allOf(withId(com.bumptech.glide.R.id.search_src_text),
                        childAtPosition(
                                allOf(withId(com.bumptech.glide.R.id.search_plate),
                                        childAtPosition(
                                                withId(com.bumptech.glide.R.id.search_edit_frame),
                                                1)),
                                0),
                        isDisplayed()));
        searchAutoComplete.perform(replaceText("atleti"), closeSoftKeyboard());
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
