package com.randhypi.academy.ui.academy

import androidx.lifecycle.ViewModel
import com.randhypi.academy.data.CourseEntity
import com.randhypi.academy.utils.DataDummy

class AcademyViewModel: ViewModel() {
    fun getCourses(): List<CourseEntity> = DataDummy.generateDummyCourses()
}