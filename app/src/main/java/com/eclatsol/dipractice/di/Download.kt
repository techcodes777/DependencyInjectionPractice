package com.eclatsol.dipractice.di

import android.util.Log

/*   //Server per thi file download thati
    HttpClient
    Executor
    Request
    Download
 */

class HttPClient {

}

class Executor {

}

class Request constructor(val httPClient: HttPClient, val executor: Executor) {
    fun getRequest() {
        Log.e("main", "getRequest: ")
    }
}

class Download constructor(val request: Request) {
    fun getDownload() {
        request.getRequest()
    }
}

object DownloadFactory {

    fun create() : Download {
        val httPClient = HttPClient()
        val executor = Executor()
        val request = Request(httPClient, executor)
        return Download(request)
    }
}

