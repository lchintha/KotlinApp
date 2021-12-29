package com.vrcmicrotech.kotlinapp

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MainActivityViewModelTest{

    lateinit var model: MainActivityViewModel
    @ExperimentalCoroutinesApi
    val dispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp(){
        model = MainActivityViewModel()
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `testing call service function for fail case`() = runBlocking{
        model.callService()
        val result = model.result.value
        assertEquals("NOT", result)
    }

}