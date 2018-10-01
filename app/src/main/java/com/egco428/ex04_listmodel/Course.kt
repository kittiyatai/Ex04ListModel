package com.egco428.ex04_listmodel

class Course(val courseNo: Int, val title: String, val description: String, val credits: Double){
    override fun toString(): String {
        return title;
    }
}
