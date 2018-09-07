package com.udacity.gradle.builditbigger.test;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.EndpointAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;

/**
 * Connected test to verify that the async task is returning a non-null string
 *
 * Used as reference the following article, as I didn't know how to test an async task:
 * https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
 *
 * On the article I've noticed, that the trick is to override the onPostExecute method with an anonymous inner class.
 *
 * After having successfully implemented the test, I've noticed that the above article does seem to contain a sample for this exercise
 * at the bottom.
 *
 * In this test case, a valid context isn't needed, but for other tests I should likely use (InstrumentrationRegistry.getContext())
 *
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTaskTest {

    @Test
    public void testAsyncTask() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);

        Context context = null;

        EndpointAsyncTask task = new EndpointAsyncTask() {
            @Override
            protected void onPostExecute(String joke) {
                assertNotNull(joke);
                assertFalse(joke.isEmpty());
                signal.countDown();
            }
        };

        task.execute(context);

        signal.await();
    }
}
