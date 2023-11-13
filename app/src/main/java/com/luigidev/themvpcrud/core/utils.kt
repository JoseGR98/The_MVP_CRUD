package com.luigidev.themvpcrud.core

import android.text.Editable

fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)