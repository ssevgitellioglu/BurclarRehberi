package com.example.burclarrehberi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_detay.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var position=intent?.extras?.get("tiklananOgePosition") as Int
        var tumBurcBilgileri=intent?.extras?.get("tumBurcBilgileri") as ArrayList<Burc?>


        txtburcOzellikleri?.setText(tumBurcBilgileri.get(position)!!.burcGenelOzellikleri)
        header.setImageResource(tumBurcBilgileri.get(position)!!.burcArkaPlan)

        setSupportActionBar(anim_toolbar)
        //geri butonu
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        collapsing_toolbar?.title=tumBurcBilgileri.get(position)!!.burcAdi

        //var bitmap= BitmapFactory.decodeResource(resources,tumBurcBilgileri.get(position).burcArkaPlan)
      //  Palette.from(bitmap).generate(object : Palette.PaletteAsyncListener{

           // override fun onGenerated(palette: Palette?) {

              //  var color=palette.getVibrantColor(R.color.colorAccent)
               // collapsing_toolbar.setContentScrimColor(color)
                //window.statusBarColor=color
            //}



      //  })

  //  }
   // override fun onSupportNavigateUp(): Boolean {
        //onBackPressed()
       // return super.onSupportNavigateUp()
    }//

}