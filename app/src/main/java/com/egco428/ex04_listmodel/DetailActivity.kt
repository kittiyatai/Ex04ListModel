package com.egco428.ex04_listmodel

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.extras;
        val title: String;
        val desc: String;
        val courseno: String;
        val coursecredits: String;
        val imgpos: String;

        if(bundle!=null){
            title = bundle.getString("title");
            desc = bundle.getString("desc");
            courseno = bundle.getString("courseno");
            coursecredits = bundle.getString("coursecredit");
            imgpos = bundle.getString("imgpos");

            tvCourseDetailName.text = title;
            tvCourseNo.text = courseno;
            tvCourseCredit.text = "Credits: "+coursecredits;
            tvTitle.text = title;
            tvDescription.text = desc;

            val res = this.resources.getIdentifier("image1010"+imgpos, "drawable", this.packageName);
            imvCourseDetail.setImageResource(res);
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu);
        return true;
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.getItemId();
        if(id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item)
    }
}
