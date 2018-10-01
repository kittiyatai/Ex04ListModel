package com.egco428.ex04_listmodel

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.acitivity_row_main.view.*
import kotlinx.android.synthetic.main.acitivity_row_main.view.tvCourseName
import kotlinx.android.synthetic.main.activity_detail.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lvMain.adapter = myCustomAdapter2();

        /*lvMain.setOnItemClickListener{ parent, view, position, id ->
            val course = data!!.get(position); // !! helps force the data to be put in the course (even though course type is not defined) //when ArrayList is created, .get to get the data at specific position
            displayDetail(course);

            val intent = Intent(this, DetailActivity::class.java);

            val pos = position%3+1;

            intent.putExtra("title",course.toString());
            intent.putExtra("desc",course.description);
            intent.putExtra("courseno",course.courseNo.toString());
            intent.putExtra("coursecredit",course.credits.toString());
            intent.putExtra("imgpos",pos.toString());
            startActivity(intent);
        };*/

    }

    private fun displayDetail(course: Course){
        Log.d("DataProvider", "Title: " + course.title);
    }

    private class myCustomAdapter2: BaseAdapter(){

        private val names = arrayListOf<String>("Moji","Makham","Mantou","Milo","Munji","Moji","Makham","Mantou","Milo","Munji","Moji","Makham","Mantou","Milo","Munji")

        override fun getCount(): Int { return names.size }

        override fun getItem(position: Int): Any { return names[position] }

        override fun getItemId(position: Int): Long { return position.toLong() }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            val view: View;

            if(convertView == null){
                val layoutInflater = LayoutInflater.from(viewGroup!!.context);
                view = layoutInflater.inflate(R.layout.acitivity_row_main,viewGroup,false);
                val viewHolder = ViewHolder(view.tvCourseName);
                view.tag = viewHolder;
            } else{
                view = convertView;
            }

            val viewHolder = view.tag as ViewHolder;
            viewHolder.titleName.text = names[position];

            return view;
        }

        private class ViewHolder(val titleName: TextView){}
    }

    /*private class myCustomAdapter(var context: Context, var objects: ArrayList<Course>): BaseAdapter(){ //Context is the root obj. Referring to any obj in the layout activity_main.xml (ex.ListView: id:lvMain, TextView: id:tvMain)

        override fun getCount(): Int { return objects.size }

        override fun getItem(position: Int): Any { return objects[position] }

        override fun getItemId(position: Int): Long { return position.toLong() }

        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {

            //update data into viewHolder instead of layout directly, dont need to inflate layout everytime when called
            val greyColor = Color.parseColor("#E0E0E0");

            val view: View;
            val course = objects[position];

            if(convertView == null){ //If we've already called inflater once, convertView will not be null. So we call layoutInflater only when the inflater is not yet called.
                val layoutInflater = LayoutInflater.from(viewGroup!!.context);
                view = layoutInflater.inflate(R.layout.acitivity_row_main,viewGroup,false);
                val viewHolder = ViewHolder(view.tvCourseName, view.imvCourse);
                view.tag = viewHolder;
            } else{
                view = convertView;
            }

            val viewHolder = view.tag as ViewHolder;
            viewHolder.titleTextView.text = course.title;
            var imgpos = position%3+1;
            val res = context.resources.getIdentifier("image1010"+imgpos, "drawable", context.packageName);
            viewHolder.imgCourse.setImageResource(res);

            *//*rowMain.imvCourse.setImageResource(res);
            rowMain.tvCourseName.text = course.title;

            if(position%2 == 0) {
                rowMain.setBackgroundColor(greyColor);
            }*//*
            return view;
        }

        private class ViewHolder(val titleTextView: TextView, val imgCourse: ImageView){}
    }*/
}
