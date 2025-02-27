package com.sitadigi.coachingtop

import androidx.lifecycle.LiveData
import androidx.room.InvalidationTracker
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import javax.annotation.Nullable


class LiveDataTestUtil {
     /*   @Throws(InterruptedException::class)
        fun <T> getValue(liveData: LiveData<T>): T? {
            val data = arrayOfNulls<Any>(1)

            val latch = CountDownLatch(1)

            val observer: InvalidationTracker.Observer<T> = object : InvalidationTracker.Observer<T>() {
                fun onChanged(@Nullable o: T) {
                    data[0] = o

                    latch.countDown()

                    liveData.removeObserver(this)
                }
            }

            liveData.observeForever(observer)

            latch.await(2, TimeUnit.SECONDS)

            return data[0] as T?
        }*/
    }
