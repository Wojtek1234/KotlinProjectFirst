package com.stsg.kotlinprojecttest.domain

/**
 * Created by wojtek on 18.09.15.
 *STSG POLAND ALL RIGHTS RESERVED
 */
public interface Command<T> {
    fun execute(): T
}

