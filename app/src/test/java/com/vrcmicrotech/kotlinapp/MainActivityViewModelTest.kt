package com.vrcmicrotech.kotlinapp

import io.mockk.MockKAnnotations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class MainActivityViewModelTest{

    lateinit var model: MainActivityViewModel
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        Dispatchers.setMain(dispatcher)
        model = MainActivityViewModel()
    }

    @Test
    fun testingCallService() = runBlocking{
        model.callService()
        val res = model.result.value
        assertEquals("RESULT", res)
    }

}