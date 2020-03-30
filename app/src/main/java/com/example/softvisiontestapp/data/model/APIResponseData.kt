package com.example.softvisiontestapp.data.model


data class Row(val title: String?,
               val description: String?,
               val imageHref: String?)

data class APIResponseData(val title: String,
                           val rows: List<Row>)

data class APIResponse(val data: APIResponseData? = null, val throwable: Throwable? = null)
