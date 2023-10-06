package com.example.mvvmretrofit.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class QuotesResponse(
    val count: Int? = null,
    val lastItemIndex: Int? = null,
    val page: Int? = null,
    val results: List<Result?>? = null,
    val totalCount: Int? = null,
    val totalPages: Int? = null
):Parcelable