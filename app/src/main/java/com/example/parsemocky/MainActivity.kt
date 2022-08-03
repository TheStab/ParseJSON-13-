package com.example.parsemocky

import android.app.DownloadManager
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.Toast
import androidx.loader.content.AsyncTaskLoader
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.parsemocky.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private val url = "https://run.mocky.io/v3/3588163c-a9c8-488c-af9a-534b392e7128"

    private lateinit var imageSlider :ImageSlider
    private lateinit var binding: ActivityMainBinding

    private lateinit var status : String
    private lateinit var maxWeight : String
    private lateinit var address : String

    private lateinit var drumDiameter : String
    private lateinit var frequency : String
    private lateinit var maxTravelSpeed : String
    private lateinit var enginePower : String
    private lateinit var standardCompactionWidth : String
    private lateinit var fuelType : String
    private lateinit var dimensions : String
    private lateinit var weight : String

    private lateinit var brandName : String
    private lateinit var category : String
    private lateinit var structure : String

    private lateinit var firstJPG : String
    private lateinit var secondJPG : String
    private lateinit var thirdJPG : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val  view = binding.root
        setContentView(R.layout.activity_main)

        request()

        imageSlider = findViewById(R.id.sliderID)
        val slideModel = arrayListOf<SlideModel>()

        //val obj = JSONObject(im)

//        val employee: JSONObject = obj.getJSONObject("equipmentMedia")
//        firstJPG = employee.getString("path")
//        Toast.makeText(this, firstJPG, Toast.LENGTH_SHORT).show()


//        try {
//            val obj = JSONObject(im)
//
//            val employee: JSONObject = obj.getJSONObject("equipmentMedia")
//            firstJPG = employee.getString("path")
//            Toast.makeText(this, firstJPG, Toast.LENGTH_SHORT).show()
//            val files: JSONObject = employee.getJSONObject("files")
//            firstJPG = files.getString("path")
//            Toast.makeText(this, firstJPG, Toast.LENGTH_SHORT).show()
//
//
//        } catch (e: JSONException){
//            e.printStackTrace()
//        }
//
        slideModel.add(SlideModel("https://cf.sam.strabag.io/media%2Fc7d6e8a7-9ad8-4805-9c33-cf21a5c039a9%2FBOMAG%20BW100.jpg", ScaleTypes.FIT))
        slideModel.add(SlideModel("https://cf.sam.strabag.io/media%2Fc7d6e8a7-9ad8-4805-9c33-cf21a5c039a9%2FBOMAG%20BW100%20Inv.jpg", ScaleTypes.FIT))
        slideModel.add(SlideModel("https://cf.sam.strabag.io/media%2Fc7d6e8a7-9ad8-4805-9c33-cf21a5c039a9%2FIMG_2200.JPG", ScaleTypes.FIT))


        imageSlider.setImageList(slideModel, ScaleTypes.FIT)

    }

    private fun request(){
        val queue = Volley.newRequestQueue(this)
        val requestHTTP = StringRequest(Request.Method.GET,url,
             Response.Listener { response ->
                val data = response.toString()
                val jArray = JSONArray(data)
                for (i in 0 until jArray.length()){
                    val jObject = jArray.getJSONObject(i)
//                    val tt = jObject.getString("telematicBox")
//                    Toast.makeText(this, tt, Toast.LENGTH_SHORT).show()
//                    val a = jObject.getJSONObject("equipmentMedia")
//                    val b = a.getJSONObject("files")
//                    val equipmentMedia = jObject.getJSONObject("equipmentMedia")
//                    val jujArray = JSONArray(equipmentMedia)
//                    for (j in 0 until jujArray.length()){
//                        val json = jujArray.getJSONObject(j)
//                    }

//                    Toast.makeText(this, userID, Toast.LENGTH_SHORT).show()
                }
            }, Response.ErrorListener{})
        queue.add(requestHTTP)
    }

}












