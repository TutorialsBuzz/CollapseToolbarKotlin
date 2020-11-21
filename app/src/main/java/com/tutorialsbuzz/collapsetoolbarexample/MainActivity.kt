package com.tutorialsbuzz.collapsetoolbarexample

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.toBitmap
import androidx.palette.graphics.Palette
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar.setTitle(getResources().getString(R.string.user_name));
        dynamicToolbarColor()
        toolbarTextAppernce()
    }

    private fun dynamicToolbarColor() {

        val bitmap = profile_id.background.toBitmap()

        Palette.from(bitmap).generate { palette ->
            collapsing_toolbar.setContentScrimColor(palette!!.getMutedColor(R.attr.colorPrimary))
            collapsing_toolbar.setStatusBarScrimColor(palette.getMutedColor(R.attr.colorPrimaryDark))
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.statusBarColor = palette.getMutedColor(R.attr.colorPrimaryDark)
            }
        }
    }


    private fun toolbarTextAppernce() {
        collapsing_toolbar.setCollapsedTitleTextAppearance(R.style.collapsedappbar)
        collapsing_toolbar.setExpandedTitleTextAppearance(R.style.expandedappbar)
    }
}