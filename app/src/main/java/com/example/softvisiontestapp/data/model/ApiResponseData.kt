package com.example.softvisiontestapp.data.model


data class Row(val title: String,
               val description: String,
               val imageHref: String)

data class ApiResponseData(val title: String,
                           val rows: List<Row>)
