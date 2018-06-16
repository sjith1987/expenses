package com.nominalista.expenses.userinterface.common

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.nominalista.expenses.R

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        protected val ANIMATION_DEFAULT = 0
        @JvmStatic
        protected val ANIMATION_SLIDE_FROM_RIGHT = 1
        @JvmStatic
        protected val ANIMATION_SLIDE_FROM_BOTTOM = 2
    }

    protected open var animationKind = ANIMATION_DEFAULT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingEnterTransition()
    }

    private fun overridePendingEnterTransition() {
        when (animationKind) {
            ANIMATION_SLIDE_FROM_RIGHT ->
                overridePendingTransition(R.anim.slide_from_right, R.anim.none)
            ANIMATION_SLIDE_FROM_BOTTOM ->
                overridePendingTransition(R.anim.slide_from_bottom, R.anim.none)
        }
    }

    override fun finish() {
        super.finish()
        overridePendingExitTransition()
    }

    private fun overridePendingExitTransition() {
        when (animationKind) {
            ANIMATION_SLIDE_FROM_RIGHT ->
                overridePendingTransition(R.anim.none, R.anim.slide_to_right)
            ANIMATION_SLIDE_FROM_BOTTOM ->
                overridePendingTransition(R.anim.none, R.anim.slide_to_bottom)
        }
    }

    override fun onSupportNavigateUp() = findNavController(R.id.fragment_navigation_host).navigateUp()
}