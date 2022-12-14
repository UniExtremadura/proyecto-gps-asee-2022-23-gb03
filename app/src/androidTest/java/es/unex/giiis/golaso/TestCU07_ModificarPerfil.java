package es.unex.giiis.golaso;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
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
public class TestCU07_ModificarPerfil {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testCU07_ModificarPerfil() throws InterruptedException {
        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.edit_user),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("sergio"), closeSoftKeyboard());

        Thread.sleep(1000);

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.edit_password),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(replaceText("7d7g5sj8"), closeSoftKeyboard());

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

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.buttonEdit), withText("Editar"),
                        childAtPosition(
                                allOf(withId(R.id.fragment_perfil),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_activity_main),
                                                0)),
                                2),
                        isDisplayed()));
        materialButton2.perform(click());

        Thread.sleep(1000);

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.modify_user), withText("sergio"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("Gabriel"));

        Thread.sleep(1000);

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.modify_user), withText("Gabriel"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText4.perform(closeSoftKeyboard());

        Thread.sleep(1000);

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.modify_password), withText("7d7g5sj8"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("7d7g5sj7"));

        Thread.sleep(1000);

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.modify_password), withText("7d7g5sj7"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                0),
                        isDisplayed()));
        appCompatEditText6.perform(closeSoftKeyboard());

        Thread.sleep(1000);

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.btn_edit), withText("EDITAR"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_activity_main),
                                        0),
                                2),
                        isDisplayed()));
        materialButton3.perform(click());
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
