package com.masacre.flickr.extensions

fun <T> MutableCollection<T>.replaceContent(items : Iterable<T>) {
    clear()
    addAll(items)
}