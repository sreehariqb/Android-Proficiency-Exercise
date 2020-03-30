package com.example.softvisiontestapp.ui
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.softvisiontestapp.R
import com.example.softvisiontestapp.data.model.APIResponse
import com.example.softvisiontestapp.data.model.APIResponseData
import com.example.softvisiontestapp.data.model.Row
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun whenNonEmptyDataReturnedFromAPI() {
        activityRule.activity.viewModel.apiResponseData.postValue(APIResponse(testApiResponseData, null))
        onView(withId(R.id.dataListView)).check(matches(isDisplayed()))
    }

    @Test
    fun whenEmptyDataReturnedFromAPI() {
        activityRule.activity.viewModel.apiResponseData.postValue(APIResponse(null, testThrowable))
        onView(withId(R.id.dataListView)).check(matches(not (isDisplayed())))
    }

    private val testRow = Row("title", "description", "imageHref")
    private val testApiResponseData = APIResponseData("title", listOf(testRow))
    private val testThrowable = Throwable("error")
}
