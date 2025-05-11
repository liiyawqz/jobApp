package com.example.jobapp.Activity

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jobapp.Adapter.CategoryAdapter
import com.example.jobapp.Adapter.JobAdapter
import com.example.jobapp.Model.JobModel
import com.example.jobapp.R
import com.example.jobapp.ViewModel.MainViewModel
import com.example.jobapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initLocation()
        initCategory()
        initSuggest()
        initRecent("0")
    }

    private fun initRecent(cat:String) {
        var data:List<JobModel>
        if (cat=="0"){
            data = mainViewModel.loadData().sortedBy { it.category }
        }else{
            data = mainViewModel.loadData().filter { it.category==cat }
        }

        binding.recyclerViewRecent.layoutManager= LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewRecent.adapter=JobAdapter(data)
    }

    private fun initSuggest() {
        binding.progressBarSuggest.visibility=View.VISIBLE
        binding.recyclerViewSuggest.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerViewSuggest.adapter = JobAdapter(mainViewModel.loadData())
        binding.progressBarSuggest.visibility = View.GONE
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility= View.VISIBLE
        binding.recyclerViewCategory.layoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        binding.recyclerViewCategory.adapter=CategoryAdapter(mainViewModel.loadCategory(),object :CategoryAdapter.ClickListener{
            override fun onClick(category: String) {
                initRecent(category)
            }

        })
        binding.progressBarCategory.visibility=View.GONE
    }

    private fun initLocation(){
        val adapter = ArrayAdapter(this, R.layout.spinner_item, mainViewModel.loadLocation())
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.LocationSp.adapter = adapter
    }
}