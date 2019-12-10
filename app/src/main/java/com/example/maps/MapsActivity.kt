package com.example.maps

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in uty and move the camera
        val uty = LatLng(-7.747033, 110.355398)
        val kos=LatLng(-7.7456716, 110.3590289)
        val pom=LatLng(-7.7469596, 110.3539143)
        val burjo=LatLng(-7.7480788, 110.3543578)
        mMap.addMarker(MarkerOptions().position(uty).title("Universitas Tenologi Yogyakarta")
            .snippet("Terletak di Yogya").icon(bitmapDescriptorFromVector(
                getApplicationContext(),
                R.drawable.uty
            )))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(uty,16.0f))

        mMap.addMarker(MarkerOptions().position(kos).title("kos saya")
            .snippet("Terletak di dusun Nganti").icon(BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_BLUE
            )))

        mMap.addMarker(MarkerOptions().position(pom).title("Pertamina")
            .snippet("Terletak di samping UTY").icon(bitmapDescriptorFromVector(
                getApplicationContext(),
                R.drawable.pert
            )))

        mMap.addMarker(MarkerOptions().position(burjo).title("Burjo Anti-galau")
            .snippet("Terletak di samping UTY").icon(BitmapDescriptorFactory.defaultMarker(
                BitmapDescriptorFactory.HUE_GREEN
            )))
    }

    private fun bitmapDescriptorFromVector(
        context: Context,
        vectorResId: Int
    ): BitmapDescriptor? {
        val vectorDrawable = ContextCompat.getDrawable(context,vectorResId)
        vectorDrawable!!.setBounds(0,0, vectorDrawable!!.intrinsicWidth,vectorDrawable.intrinsicHeight)
        val bitmap=Bitmap.createBitmap(vectorDrawable.intrinsicWidth,vectorDrawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888)

        val canvas:Canvas= Canvas(bitmap)
        vectorDrawable.draw(canvas)
        return BitmapDescriptorFactory.fromBitmap(bitmap)
    }
}
