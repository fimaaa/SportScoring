package com.example.sportscorer.ui.activity.post

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sportscorer.ui.activity.main.MainActivity
import com.example.sportscorer.R
import com.example.sportscorer.databinding.ActivityPostListBinding
import com.example.sportscorer.injection.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class PostListActivity: AppCompatActivity() {
    private lateinit var binding: ActivityPostListBinding
    private lateinit var viewModel: PostListViewModel

    companion object{
        const val EVENT_STARTACTIVIY_MAIN = 0
    }

    private var errorSnackbar: Snackbar? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_post_list)
        binding.postList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        viewModel =
            ViewModelProviders.of(this, ViewModelFactory(this)).get(PostListViewModel::class.java)
//        ViewModelProvider(this).get(PostListViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        viewModel.eventClick.observe(this, Observer {
            eventHandle(it?:-1)
        })
        binding.viewModel = viewModel
    }

    private fun showError(@StringRes errorMessage:Int){
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }

    private fun eventHandle(event:Int){
        when(event){
            EVENT_STARTACTIVIY_MAIN ->{
                startActivity(MainActivity.startActivity(this))
            }
            else->{
                Toast.makeText(this,R.string.post_error,Toast.LENGTH_SHORT).show()
            }
        }
    }
}