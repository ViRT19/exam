package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AboutFragment : Fragment() {

    lateinit var developerRecycleView: RecyclerView
    lateinit var showWebSiteButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_about, container, false)
        val developerNames: List<String> = listOf("Roman", "Sergey", "Alexandra")

        showWebSiteButton = view.findViewById(R.id.web_site_button)
        developerRecycleView = view.findViewById(R.id.developer_recycler_view)
        developerRecycleView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        developerRecycleView.adapter = DeveloperAdapter(developerNames)

        showWebSiteButton.setOnClickListener {
            val link = Uri.parse("https://gtlab.pro/")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }

        return view
    }


}