package com.okawa.store.data

data class Result<T>(val status: Status, val message: String?, val data: T?) {

    companion object {

        fun <T>success(data: T?) = Result(Status.SUCCESS, null, data)

        fun <T>error(message: String?, data: T?) = Result(Status.ERROR, message, data)

        fun <T>loading(data: T?) = Result(Status.LOADING, null, data)

    }

}